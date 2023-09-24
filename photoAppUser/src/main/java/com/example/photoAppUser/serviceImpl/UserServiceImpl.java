package com.example.photoAppUser.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.apache.hc.core5.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.photoAppUser.dto.AlbumResponseModel;
import com.example.photoAppUser.dto.CreateUserRequestModel;
import com.example.photoAppUser.dto.UserResponseModel;
import com.example.photoAppUser.entity.AppUser;
import com.example.photoAppUser.feignClient.AlbumFeignClient;
import com.example.photoAppUser.repository.UserRepository;
import com.example.photoAppUser.service.UserService;
import com.example.photoAppUser.utility.ResponsePayLoad;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AlbumFeignClient userFeignClient;
	@Override
	public ResponsePayLoad createUser(CreateUserRequestModel userDetails) {
		
		ResponsePayLoad payload =saveUser(userDetails);
		return payload;
	}
	private ResponsePayLoad saveUser(CreateUserRequestModel userDetails) {
		AppUser user =null;
		if(userDetails.getId()==null) {
			user = new AppUser();
			userDetails.setUserId(UUID.randomUUID().toString());
		}else {
			user =userRepository.findById(userDetails.getId()).get();
		}
		bCryptPasswordEncoder =new BCryptPasswordEncoder();
		user.setEmail(userDetails.getEmail());
		user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		user.setPassword(userDetails.getPassword());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUserId(userDetails.getUserId());
		userRepository.save(user);
		return new ResponsePayLoad("Successfully saved User!", HttpStatus.SC_OK+"",user);
		
	}

	/*public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser user = userRepository.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException(email);
		}
		return  new User(user.getEmail(), user.getEncryptedPassword(),true,true,true,true,new ArrayList<>());
	}*/
	@Override
	public AppUser getUserByEmail(String email) {
		return  userRepository.findByEmail(email);
	}
	@Override
	public UserResponseModel getUserByUserId(String id) {
		AppUser user= userRepository.findByUserId(id);
		
		UserResponseModel userModel = new ModelMapper().map(user, UserResponseModel.class);
		/*String albumUrl = String.format("http://ALBUMS-WS/users/%s/albums", id);
		 * ResponseEntity<List<AlbumResponseModel>> albumResponse = restTemplate.
				exchange(albumUrl, HttpMethod.GET,null,new 
						ParameterizedTypeReference<List<AlbumResponseModel>>() {
				});
				List<AlbumResponseModel> albumList = albumResponse.getBody();
				*/
		List<AlbumResponseModel> albumList = userFeignClient.getAlbums(id);
		
		userModel.setAlbums(albumList);
		return userModel;
	}
	@Override
	public UserResponseModel getFailedUser() {
		UserResponseModel userModel = new UserResponseModel();
		List<AlbumResponseModel> albumList = userFeignClient.getAlbumsFail("FailedId");
		userModel.setEmail("Failed@gmail.com");
		userModel.setFirstName("Failed Person");
		userModel.setLastName("Album");
		userModel.setUserId("UserFailedId");
		userModel.setAlbums(albumList);
		
		return userModel;
	}

}

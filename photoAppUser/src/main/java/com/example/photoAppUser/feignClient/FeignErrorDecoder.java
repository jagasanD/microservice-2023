package com.example.photoAppUser.feignClient;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {

		case 400: {
			break;
		}
		case 404: {
			System.out.println("method key  "+methodKey);
			System.out.println("response  "+response);
			if (methodKey.contains("getAlbums")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Users album are not Found");
			}
			break;
		}
		case 500: {
			System.out.println("method key  "+methodKey);
			System.out.println("response  "+response);
			if (methodKey.contains("getAlbumsFail")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Albums api called failed method");
			}
			break;
		}
		default:
			return new Exception("500 Server exception");

		}
		return null;
	}

}

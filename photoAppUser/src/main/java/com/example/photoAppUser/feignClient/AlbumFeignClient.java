package com.example.photoAppUser.feignClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.photoAppUser.dto.AlbumResponseModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="albums-ws")
public interface AlbumFeignClient {
	
	@GetMapping("/users/{id}/albums")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);
	
	@GetMapping("/users/{id}/albumsFail")
	@Retry(name="albums-ws")
	@CircuitBreaker(name="albums-ws", fallbackMethod="albumsFallbackmethod")
	public List<AlbumResponseModel> getAlbumsFail(@PathVariable String id);

	
	 default List<AlbumResponseModel> albumsFallbackmethod(String id, Throwable throwable) {
		 System.out.println("------------calling fallback methods----------");
		return new ArrayList<>();
		
	}
}

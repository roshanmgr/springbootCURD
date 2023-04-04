package com.example.sahayogi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = ("*"))
@RestController
@RequestMapping("/sahayogi/user")

public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.OK)
	
	public UserResponseDto addUser (@RequestBody UserCreateDto userCreateDto) {
		return userservice.adduser(userCreateDto);
	}
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public UserResponseListDto getUser() {
		return userservice.getUser();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public UserResponseDto getUserById(@PathVariable("id") long id) {
		return userservice.getUserById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public UserResponseDto UserUpdate(@PathVariable("id") long id, @RequestBody UserUpdateDto userUpdateDto) {
		return userservice.userUpdate(id, userUpdateDto);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteUserById(@PathVariable("id") long id) throws Exception {
		userservice.deleteUserById(id);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDto request) {
		return userservice.login(request);
	

}
}

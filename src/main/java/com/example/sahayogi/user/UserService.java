package com.example.sahayogi.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sahayogi.security.BCrypt;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;

	public UserResponseDto adduser(UserCreateDto userCreateDto) {
		Users user = new Users();
		user.setName(userCreateDto.getName());
		user.setAddress(userCreateDto.getAddress());
		user.setMobile_no(userCreateDto.getMobile_no());
		user.setRole("guest");

//	 user.setEsewa_id(userCreateDto.getEsewa_id());
//	 user.setPassword(userCreateDto.getPassword());
		String orginalPassword = userCreateDto.getPassword();
		String encryptedPassword = BCrypt.hashpw(orginalPassword, BCrypt.gensalt());
		user.setPassword(encryptedPassword);
		Users saveuser = userRepository.save(user);
		return getUserResponseDto(saveuser);
	}

	public UserResponseDto getUserResponseDto(Users user) {
		UserResponseDto response = new UserResponseDto();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setAddress(user.getAddress());
		response.setMobile_no(user.getMobile_no());
		response.setRole(user.getRole());
//	 response.setEsewa_id(user.getEsewa_id());
//	 response.setPassword(user.getPassword());
		return response;

	}

	public UserResponseListDto getUser() {
		List<UserResponseDto> userResponseDto = new ArrayList<>();
		List<Users> users = (List<Users>) userRepository.findAll();
		for (Users user : users) {
			userResponseDto.add(getUserResponseDto(user));

		}

		UserResponseListDto response = new UserResponseListDto();
		response.setUsers(userResponseDto);
		response.setTotal((long) userResponseDto.size());
		return response;
	}

	public UserResponseDto userUpdate(long id, UserUpdateDto userUpdateDto) {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			Users user = optionalUser.get();
			user.setName(userUpdateDto.getName());
			user.setAddress(userUpdateDto.getAddress());
			user.setMobile_no(userUpdateDto.getMobile_no());
//		user.setEsewa_id(userUpdateDto.getEsewa_id());
			user.setPassword(userUpdateDto.getPassword());
//			user.setRole(userUpdateDto.getRole());
			Users savedUser = userRepository.save(user);
			return getUserResponseDto(savedUser);
		}
		return null;
	}

	public UserResponseDto getUserById(long id) {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return getUserResponseDto(optionalUser.get());

		}
		return null;
	}

	public void deleteUserById(long id) throws Exception {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			Users user = optionalUser.get();
			userRepository.deleteById(id);
		} else {
			throw new Exception("User having id" + " " + id + " " + "is not found");
		}

	}

	public String login(LoginRequestDto request) {
		/**
		 * 1. check user with given username if exist check password and return status
		 * 2. if user does not exist then return user not found message
		 */

		Users user = userRepository.findByName(request.getName());

		if (user == null) {
			return "User does not exist. Please register first.";
		}

		boolean checkpw = BCrypt.checkpw(request.getPassword(), user.getPassword());
		if (!checkpw)
			return "Invalid password. Please type your correct password.";

		user.setLoggedIn(true);
		userRepository.save(user);

		return "Success!";
	}

	public String logout(LogoutRequestDto request) {
		Users user = userRepository.findByName(request.getName());

		if (user == null) {
			return "User does not exist. Please register first.";
		}

		user.setLoggedIn(false);
		userRepository.save(user);

		return "Success!";
	}

}

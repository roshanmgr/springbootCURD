package com.example.sahayogi.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Users,Long>{

	Users findByName(String name);
	
//	Users findByMobileNumber(String mobileNumber);

}

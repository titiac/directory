package com.example.directory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class DirectoryApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("pzhw"));
		System.out.println(passwordEncoder.encode("pyy"));
		System.out.println(passwordEncoder.matches("pzhw","$2a$10$8c7tObttCQqIu.ZIrcdvm.WvuJPp3R8BDm9/UjaGuMs7vToaEAugC"));
	}

}

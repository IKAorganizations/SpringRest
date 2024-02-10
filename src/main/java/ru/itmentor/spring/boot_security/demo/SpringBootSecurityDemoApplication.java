package ru.itmentor.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itmentor.spring.boot_security.demo.dao.UserRepository;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
//		ApplicationContext context = SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
//
//		PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
//
//		UserRepository userService = context.getBean(UserRepository.class);
//		RoleService roleService = context.getBean(RoleService.class);
//
//		User user = new User();
//
//		user.setUsername("Kit");
//		user.setAge(25);
//		user.setEmail("kit@gmail.com");
//		user.setPassword(passwordEncoder.encode("kit"));
//
//		Set<Role> role = new HashSet<>();
//
//		role.add(roleService.getRoleByName("ADMIN"));
//
//		user.setRoles(role);
//
//		userService.save(user);


	}

}

/**
 *
 */
package com.bits.assignment.universalt10.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.assignment.universalt10.userservice.model.User;
import com.bits.assignment.universalt10.userservice.model.UserDetail;
import com.bits.assignment.universalt10.userservice.service.UserDetailService;

/**
 * @author Vicky
 *
 */
@RestController
public class UserDetailController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDetailService service;

	@GetMapping("/users")
	public ResponseEntity<List<UserDetail>> getAllUserDetails() {

		return ResponseEntity.ok(service.getAllUsers());

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserDetail> getUserDetailbyId(@PathVariable String id) throws Exception {
		UserDetail user = service.getUserDetailById(id);
		if (user == null) {
			throw new Exception("User was not found");
		}
		return ResponseEntity.ok(user);
	}

	@GetMapping("/user/disable/{id}")
	public ResponseEntity<Boolean> disableUser(@PathVariable String id) {
		return ResponseEntity.ok(service.disableUser(id));
	}

	@PostMapping("/user")
	public ResponseEntity<UserDetail> createUser(@RequestBody UserDetail user) throws Exception {
		return ResponseEntity.ok(service.createUser(user));
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(service.login(user));
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserDetail> updateUser(@RequestBody UserDetail user, @PathVariable String id)
			throws Exception {
		return ResponseEntity.ok(service.updateUser(user, id));
	}

	@DeleteMapping("/user/{id}")
	public HeadersBuilder<?> deleteUser(@PathVariable String id) throws Exception {
		service.deleteUser(id);
		return ResponseEntity.noContent();
	}

}

/**
 *
 */
package com.bits.assignment.universalt10.userservice.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bits.assignment.universalt10.userservice.model.User;
import com.bits.assignment.universalt10.userservice.model.UserDetail;
import com.bits.assignment.universalt10.userservice.repository.UserDetailRepository;

/**
 * @author Vicky
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDetailRepository repository;

	@Override
	public List<UserDetail> getAllUsers() {

		return repository.findAll();
	}

	@Override
	public UserDetail getUserDetailById(String id) {
		Optional<UserDetail> opt = repository.findById(id);
		return opt.orElse(null);
	}

	@Override
	public UserDetail createUser(UserDetail user) throws UnsupportedEncodingException {
		if (user != null) {
			String username = user.getUserName();
			if (StringUtils.hasText(username)) {
				String password = Base64.getEncoder().encodeToString(user.getPassword().getBytes("utf-8"));
				user.setPassword(password);
				return repository.save(user);

			}
		}

		return null;
	}

	@Override
	public boolean disableUser(String id) {
		UserDetail user = getUserDetailById(id);
		if (user != null) {
			user.setBlocked(true);
			repository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public List<UserDetail> getAllAdminUsers() {
		// TODO Auto-generated method stub
		return repository.findByAdmin(true);
	}

	@Override
	public void deleteUser(String id) throws Exception {
		UserDetail user = getUserDetailById(id);
		if (user == null) {
			throw new Exception("Unable to find the user in the database");
		}
		repository.delete(user);

	}

	@Override
	public UserDetail updateUser(UserDetail user, String id) throws Exception {
		UserDetail dbUser = getUserDetailById(id);
		if (dbUser == null) {
			throw new Exception("Invalid user Id");
		}
		UserDetail dbUser2 = repository.findByUserName(user.getUserName());
		if (dbUser2 != null && !dbUser2.getId().equals(user.getId())) {
			throw new Exception("The Username Already exists, please try different name");
		}
		if (!dbUser.getPassword().equals(user.getPassword())) {
			String encodedpassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes("utf-8"));
			user.setPassword(encodedpassword);
		}

		return repository.save(user);
	}

	@Override
	public String login(User user) throws Exception {
		String userName = user.getUserName();
		String password = user.getPassword();
		UserDetail userDetail = repository.findByUserName(userName);
		if (userDetail != null) {
			if (userDetail.getUserName().equals(userName)) {
				byte[] decodedBytes = Base64.getDecoder().decode(userDetail.getPassword());
				String decodedpassword = new String(decodedBytes);
				if (decodedpassword.equals(password)) {
					return userDetail.getFirstName() + " Welcome to UniversalT10";
				} else {
					throw new Exception("Incorrect Username / Password");
				}
			} else {
				throw new Exception("Incorrect Username / Password");
			}
		} else {
			throw new Exception("User is not Registered");
		}
	}

}

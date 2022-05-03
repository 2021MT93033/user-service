/**
 *
 */
package com.bits.assignment.universalt10.userservice.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.bits.assignment.universalt10.userservice.model.User;
import com.bits.assignment.universalt10.userservice.model.UserDetail;

/**
 * @author Vicky
 *
 */
public interface UserDetailService {

	List<UserDetail> getAllUsers();

	UserDetail getUserDetailById(String id);

	UserDetail createUser(UserDetail user) throws UnsupportedEncodingException;

	boolean disableUser(String id);

	List<UserDetail> getAllAdminUsers();

	void deleteUser(String id) throws Exception;

	UserDetail updateUser(UserDetail user, String id) throws Exception;

	String login(User user) throws Exception;

}

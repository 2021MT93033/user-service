/**
 *
 */
package com.bits.assignment.universalt10.userservice.model;

import java.util.Objects;

/**
 * @author Vicky
 *
 */

public class User {

	private String userName;
	private String password;

	public User() {

	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}

}

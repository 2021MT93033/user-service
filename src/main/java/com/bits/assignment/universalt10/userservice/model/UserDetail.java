/**
 *
 */
package com.bits.assignment.universalt10.userservice.model;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Vicky
 *
 */
@Document
public class UserDetail extends BaseEntity {

	private String firstName;
	private String lastName;
	private int age;
	private String userName;
	private String password;
	boolean admin;
	boolean blocked;

	public UserDetail() {

	}

	public UserDetail(String firstName, String lastName, int age, String userName, String password, boolean admin,
			boolean blocked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.admin = admin;
		this.blocked = blocked;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
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

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the blocked
	 */
	public boolean isBlocked() {
		return blocked;
	}

	/**
	 * @param blocked the blocked to set
	 */
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public int hashCode() {
		return Objects.hash(admin, age, blocked, firstName, lastName, password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetail other = (UserDetail) obj;
		return admin == other.admin && age == other.age && blocked == other.blocked
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserDetail [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", userName="
				+ userName + ", password=" + password + ", admin=" + admin + ", blocked=" + blocked + "]";
	}

}

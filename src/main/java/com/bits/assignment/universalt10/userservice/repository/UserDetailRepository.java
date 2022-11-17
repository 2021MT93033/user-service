/**
 *
 */
package com.bits.assignment.universalt10.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bits.assignment.universalt10.userservice.model.UserDetail;

/**
 * @author Vicky
 *
 */
@Repository
public interface UserDetailRepository extends MongoRepository<UserDetail, String> {

	UserDetail findByUserName(String userName);

//	List<UserDetail> findByAdmin(boolean admin);

}

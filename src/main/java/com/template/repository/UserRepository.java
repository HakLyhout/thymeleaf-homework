package com.template.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

import com.template.model.User;

@Repository
public interface UserRepository {

	@Select("SELECT "
			+ "	id, "
			+ "	username, "
			+ "	email, "
			+ "	gender, "
			+ "	phonenumber, "
			+ "	status, "
			+ "	user_hash, "
			+ "	created_date "
			+ " FROM "
			+ "	users")
	@Results(value={
			@Result(property="phoneNumber" , column="phonenumber"),
			@Result(property="createdDate" , column="created_date"),
			@Result(property="userHash" , column="user_hash")
	})
	List<User> getAllUsers();
	
}

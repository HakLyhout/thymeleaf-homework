package com.template.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
	
	@Select("SELECT * FROM users U"+ " WHERE user_hash = #{user_hash}")
	@Results(value={
			@Result(property="userName" , column="username"),
			@Result(property="phoneNumber" , column="phonenumber"),
			@Result(property="userHash" , column="user_hash")
		
	})
	public User getUserByHash(@Param("user_hash") String userHash);
	
	@Delete("DELETE FROM users WHERE user_hash=#{user_hash}")
	public boolean deleteUser(@Param("user_hash") String userHash);
	
	@Insert("INSERT INTO users ("
			+ "	username, "
			+ "	email, "
			+ " gender, "
			+ "	phonenumber, "
			+ "	user_hash"
			+ "	) VALUES ("
			+ "	#{user.userName},"
			+ "	#{user.Email},"
			+ "	#{user.Gender},"
			+ "	#{user.phoneNumber},"
			+ "	#{user.userHash} "
			+ ")")
	@SelectKey(
			statement="SELECT last_value FROM users_id_seq",
			keyProperty="user.id", keyColumn="last_value",
			before=false,
			resultType=int.class
	)
	public boolean saveUser(@Param("user") User user);
	
	@Update("UPDATE users SET "
			+ "username=#{user.userName},"
			+ "email=#{user.Email},"
			+ "phonenumber=#{user.phoneNumber},"
			+ "status=#{user.status},"
			+ "gender=#{user.Gender}"
			+ " WHERE user_hash=#{user.userHash}")
	public boolean updateUser(@Param("user") User user);
	
	@Select("SELECT COUNT(*) FROM users WHERE gender = #{gender}")
	public int countUsersByGender(String gender);
	
	

}

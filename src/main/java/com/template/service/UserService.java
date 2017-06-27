package com.template.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.template.model.User;

public interface UserService {

	List<User> getAllUsers();
	public User getUserByHash(@Param("user_hash") String userHash);
	public boolean deleteUser(String user_hash);
	public boolean saveUser(@Param("user") User user);
	public boolean updateUser(@Param("user") User user);
	public int countUsersByGender(@Param("gender") String gender);
}

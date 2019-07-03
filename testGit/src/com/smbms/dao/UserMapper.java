package com.smbms.dao;

import java.util.List;
import java.util.Map;

import com.smbms.entity.User;

public interface UserMapper {

	/**
	 * 多条件查询
	 * @param map
	 * @return
	 */
	List<User> findUserByCondition(Map<String, Object> map);
	
	/**
	 * trim标签动态查询
	 * @param map
	 * @return
	 */
	List<User> findUserWithTrim(Map<String, Object> map);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 根据角色id数组查询该角色下所有的用户信息
	 * @param roleIds
	 * @return
	 */
	List<User> findUserListWithArray(Integer[] roleIds);
	
	/**
	 * 根据角色id数组查询该角色下所有的用户信息
	 * @param roleList
	 * @return
	 */
	List<User> findUserListWithList(List<Integer> roleList );
	
	/**
	 * 根据角色id数组查询该角色下所有的用户信息
	 * @param map
	 * @return
	 */
	List<User> findUserListWithMap(Map<String, Object> map);
 	
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<User> findUserListByPage(Map<String, Object> map);
	
	List<User> findUserListWithChoose(Map<String, Object> map);
}

package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.smbms.dao.UserMapper;
import com.smbms.entity.User;
import com.smbms.utils.MyBatisUtil;

public class TestM {

	@Test
	public void test1() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.创建map集合保存条件参数
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("userCode", "a");
		//map.put("roleId", 2);
		List<User> list = mapper.findUserByCondition(map);
		//4。遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	
	@Test
	public void test2() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.创建map集合保存条件参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userCode", "a");
		map.put("roleId", 2);
		List<User> list = mapper.findUserWithTrim(map);
		//4。遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	
	@Test
	public void test3() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		try {
			//2.创建对象
			UserMapper mapper = session.getMapper(UserMapper.class);
			//3.构建用户对象
			User user = new User();
			user.setUserName("玛丽");
			user.setGender(2);
			user.setUserRole(3);
			user.setId(19);
			//4.调用方法
			int count  = mapper.updateUser(user);
			if(count>0) {
				System.out.println("成功");
			}else {
				System.out.println("失败！");
			}
			//5.提交事务
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//6.回滚
			session.rollback();
		}finally {
			//7.关闭资源
			MyBatisUtil.closeSqlSession(session);
		}
		
	}
	
	@Test
	public void test4() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.使用数组保存角色id
		Integer [] roleIds = {1,2};
		List<User> list = mapper.findUserListWithArray(roleIds);
		//4.遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	@Test
	public void test5() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.使用list集合保存角色id
		List<Integer> roleList = new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		List<User> list = mapper.findUserListWithList(roleList);
		//4.遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	@Test
	public void test6() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		//角色id
		List<Integer> roleList = new ArrayList<Integer>();
		roleList.add(2);
		roleList.add(3);
		//条件参数
		map.put("sex",2);//性别
		map.put("roleIds", roleList);//角色id
		List<User> list = mapper.findUserListWithMap(map);
		//4.遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	@Test
	public void test7() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.创建map集合保存条件参数
		Map<String, Object> map = new HashMap<String, Object>();
		
		int pageIndex = 1;//页码
		int pageSize = 5;//每页显示的数量
		
		map.put("start", (pageIndex-1)*pageSize);//(当前页码-1)*每页显示的数量
		map.put("size",pageSize);
		List<User> list = mapper.findUserListByPage(map);
		//4。遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
	
	@Test
	public void test8() {
		//1.获取session
		SqlSession session = MyBatisUtil.createSqlSession();
		//2.创建对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//3.创建map集合保存条件参数
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("userCode", "a");
		map.put("userName", "李");
		map.put("gender", 2);
		List<User> list = mapper.findUserListWithChoose(map);
		//4。遍历
		for (User user : list) {
			System.out.println(user.getUserCode()+","+user.getUserName()+","+user.getUserRole());
		}
	}
}
	
	

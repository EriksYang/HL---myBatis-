package cn.hl.dao;


import java.util.List;

import cn.hl.util.BaseDao;
import cn.hl.vo.User;


public class UserDao extends BaseDao{
	/**
	 * 添加用户信息
	 * @param user
	 * @return
	 */
	public int add(User user){
		return this.insert("cn.hl.vo.User.reg", user);
	}
	
	/**
	 * 按照账号查询用户信息
	 * @param user
	 * @return
	 */
	public User getByAccount(User user){
		return this.selectOne("cn.hl.vo.User.getByAccount", user);
	}
	
	/**
	 * 获取收件人列表
	 * @param user
	 * @return
	 */
	public List<User> getReciver(User user){
		return this.selectList("cn.hl.vo.User.getReciverList", user);
	}
}

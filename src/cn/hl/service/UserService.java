package cn.hl.service;

import java.util.List;

import cn.hl.common.Encrypt;
import cn.hl.dao.UserDao;
import cn.hl.vo.User;

public class UserService {
	UserDao dao = new UserDao();
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public int register(User user){
		//读取出pwd（密码）
		String pwd = user.getPwd();
		
		//对密码进行加密		
		//将加密后的密码重新赋值给user对象
		user.setPwd(Encrypt.md5(pwd));
		//设置状态为1（启用）
		user.setState(1);
		//执行插入操作		
		return dao.add(user);
	}
	
	/**
	 * 执行用户登录验证
	 * @param user
	 * @return
	 */
	public User Login(User user){
		//按照账号查询用户信息
		User tempUser = dao.getByAccount(user);
		System.out.println(tempUser);
		
		//验证账号是否正确
		if(tempUser==null)
			throw new RuntimeException("账号名不存在");
		else{
			//对用户传递的密码进行加密
			String pwd = Encrypt.md5(user.getPwd());
			//验证密码是否争取
			if(!pwd.equals(tempUser.getPwd())){
				throw new RuntimeException("密码错误");
			}
			else if(tempUser.getState()!=1)
				//验证用户的状态，如果无效则抛出异常
				throw new RuntimeException("账号已被锁定");
		}
		
		return tempUser;
	}
	
	/**
	 * 获取收件人列表
	 * @param user
	 * @return
	 */
	public List<User> getRecivers(User user){
		return dao.getReciver(user);
	}
}

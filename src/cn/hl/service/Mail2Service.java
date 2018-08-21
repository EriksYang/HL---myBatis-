package cn.hl.service;

import java.util.List;

import cn.hl.dao.Mail2Dao;
import cn.hl.vo.Mail2;
import cn.hl.vo.Recive;
import cn.hl.vo.User;

public class Mail2Service {
	Mail2Dao dao = new Mail2Dao();
	/**
	 * 获取收件列表
	 * @param id :收件人Id
	 * @return
	 */
	public List<Mail2> getReciveList(int id){
		Mail2 mail2 = new Mail2();
		mail2.setReciver(new Recive(id,0,0));
		
		return dao.getReciveList(mail2);
	}
	
	/**
	 * 获取垃圾箱邮件列表
	 * @param id
	 * @return
	 */
	public List<Mail2> getDustbin(int id){
		Mail2 mail2 = new Mail2();
		mail2.setReciver(new Recive(id,0,0));
		
		return dao.getDustbin(mail2);
	}
	
	/**
	 * 获取发件箱列表
	 * @param id
	 * @return
	 */
	public List<Mail2> getSendBox(int id){
		Mail2 mail2 = new Mail2();
		mail2.setSender(new User(id,"","",0));
		
		return dao.getSendBox(mail2);
	}
	
	/**
	 * 读取邮件信息
	 * @param mailId
	 * @param userId
	 * @return
	 */
	public Mail2 readMail(int mailId,int userId){
		//获取Mail2对象
		Mail2 mail2 = new Mail2(userId,mailId);
		//修改邮件状态
		mail2.getReciver().setState(1);
		dao.setMailState(mail2);
		
		//读取邮件信息
		return dao.getMail(mail2);
	}
	
	/**
	 * 删除邮件到垃圾箱
	 * @param mailId
	 * @param userId
	 * @return
	 */
	public int delete(int mailId,int userId){
		//获取Mail2对象
		Mail2 mail2 = new Mail2(userId,mailId);
		//修改邮件状态
		mail2.getReciver().setState(9);
		return dao.setMailState(mail2);
	}
}

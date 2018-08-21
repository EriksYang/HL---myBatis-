package cn.hl.dao;

import java.util.List;

import cn.hl.util.BaseDao;
import cn.hl.vo.Mail2;

public class Mail2Dao extends BaseDao{
	/**
	 * 获取收件信息
	 * @param reciverId
	 * @return
	 */
	public List<Mail2> getReciveList(Mail2 mail2){
		return this.selectList("cn.hl.vo.Mail2.getReciveList", mail2);
	}
	
	/**
	 * 获取垃圾箱信息
	 * @param mail2
	 * @return
	 */
	public List<Mail2> getDustbin(Mail2 mail2){
		return this.selectList("cn.hl.vo.Mail2.getDustbin", mail2);
	}
	
	/**
	 * 获取发件箱信息
	 * @param mail2
	 * @return
	 */
	public List<Mail2> getSendBox(Mail2 mail2){
		return this.selectList("cn.hl.vo.Mail2.getSendBox", mail2);
	}
	
	/**
	 * 读取指定Id的邮件
	 * 
	 * @param mail2
	 * @return
	 */
	public Mail2 getMail(Mail2 mail2){
		return this.selectOne("cn.hl.vo.Mail2.getMail", mail2);
	}
	
	/**
	 * 修改邮件状态
	 * @param mail2
	 * @return
	 */
	public int setMailState(Mail2 mail2){
		return this.update("cn.hl.vo.Mail2.setState", mail2);
	}
}

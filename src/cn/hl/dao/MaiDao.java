package cn.hl.dao;

import cn.hl.util.BaseDao;
import cn.hl.vo.Mail;

public class MaiDao extends BaseDao{
	/**
	 * 将邮件信息添加到数据库中
	 * @param mail
	 * @return
	 */
	public int add(Mail mail){
		return  this.insert("cn.hl.vo.Mail.sendMail", mail);
	}
}

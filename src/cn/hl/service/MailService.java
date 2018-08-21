package cn.hl.service;

import java.sql.Date;
import java.util.List;

import cn.hl.dao.MaiDao;
import cn.hl.dao.ReciveDao;
import cn.hl.vo.Mail;
import cn.hl.vo.Recive;

public class MailService {
	MaiDao dao = new MaiDao();
	
	/**
	 * 将邮件信息添加到数据库
	 * @param mail
	 * @return
	 */
	public int sendMail(Mail mail,List<Recive> recive){
		//设置发件时间
		Date date = new Date(System.currentTimeMillis());
		mail.setCreateTime(date);
		
		if(dao.add(mail) >0){
			//处理发件人列表
			for(Recive r : recive){
				r.setMailId(mail.getMailId());
				//设置邮件状态为“未读”（0）
				//r.setState(0);	
			}
						
			//将数据插入到sys_mail_recive表中
			ReciveDao reciveDao = new ReciveDao();
			return reciveDao.add(recive);
		}
		
		return 0;
	}
	
}

package cn.hl.vo;

import java.sql.Date;

public class Mail {
	private	int mailId;
	private String title;
	private String content;
	private Date createTime;
	private int senderId;
	
	public Mail() {
		// TODO Auto-generated constructor stub
	}

	public Mail(int mailId, String title, String content, Date createTime,
			int senderId) {
		this.mailId = mailId;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.senderId = senderId;
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	@Override
	public String toString() {
		return "Mail [mailId=" + mailId + ", title=" + title + ", content="
				+ content + ", createTime=" + createTime + ", senderId="
				+ senderId + "]";
	}
	
	
	
}

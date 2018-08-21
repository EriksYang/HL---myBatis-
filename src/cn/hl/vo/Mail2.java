package cn.hl.vo;

import java.sql.Date;

public class Mail2 {
	private	int mailId;
	private String title;
	private String content;
	private Date createTime;
	private User sender;
	private Recive reciver;
	
	public Mail2() {
		// TODO Auto-generated constructor stub
	}
	
	public Mail2(int userId, int mailId) {
		this.mailId = mailId;
		reciver = new Recive(userId, mailId, 0);
	}

	public Mail2(int mailId, String title, String content, Date createTime,
			User sender, Recive reciver) {
		super();
		this.mailId = mailId;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.sender = sender;
		this.reciver = reciver;
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

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Recive getReciver() {
		return reciver;
	}

	public void setReciver(Recive reciver) {
		this.reciver = reciver;
	}

	@Override
	public String toString() {
		return "Mail2 [mailId=" + mailId + ", title=" + title + ", content="
				+ content + ", createTime=" + createTime + ", sender=" + sender
				+ ", reciver=" + reciver + "]";
	}
	
	
	
}

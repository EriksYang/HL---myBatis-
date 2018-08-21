package cn.hl.vo;

public class Recive {
	private int reciverId;
	private int mailId;
	private int state;
	
	public Recive() {
		// TODO Auto-generated constructor stub
	}

	public Recive(int reciverId, int mailId, int state) {
		super();
		this.reciverId = reciverId;
		this.mailId = mailId;
		this.state = state;
	}

	public int getReciverId() {
		return reciverId;
	}

	public void setReciverId(int reciverId) {
		this.reciverId = reciverId;
	}

	public int getMailId() {
		return mailId;
	}

	public void setMailId(int mailId) {
		this.mailId = mailId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Recive [reciverId=" + reciverId + ", mailId=" + mailId
				+ ", state=" + state + "]";
	}
	
	
}

package ask.model.vo;

import java.sql.Date;

public class Ask {
	private int askNo;
	private String askSubject;
	private String askContents;
	private String answerContents;
	private Date askDate;
	private Date answerDate;
	private String userId;
	private String disclosure;
	private String reply;
	
	
	public Ask () {}


	public Ask(int askNo, String askSubject, String askContents, String answerContents, Date askDate, Date answerDate,
			String userId, String disclosure, String reply) {
		super();
		this.askNo = askNo;
		this.askSubject = askSubject;
		this.askContents = askContents;
		this.answerContents = answerContents;
		this.askDate = askDate;
		this.answerDate = answerDate;
		this.userId = userId;
		this.disclosure = disclosure;
		this.reply = reply;
	}

	public int getAskNo() {
		return askNo;
	}

	public void setAskNo(int askNo) {
		this.askNo = askNo;
	}


	public String getAskSubject() {
		return askSubject;
	}


	public void setAskSubject(String askSubject) {
		this.askSubject = askSubject;
	}


	public String getAskContents() {
		return askContents;
	}


	public void setAskContents(String askContents) {
		this.askContents = askContents;
	}


	public String getAnswerContents() {
		return answerContents;
	}


	public void setAnswerContents(String answerContents) {
		this.answerContents = answerContents;
	}


	public Date getAskDate() {
		return askDate;
	}


	public void setAskDate(Date askDate) {
		this.askDate = askDate;
	}


	public Date getAnswerDate() {
		return answerDate;
	}


	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getDisclosure() {
		return disclosure;
	}


	public void setDisclosure(String disclosure) {
		this.disclosure = disclosure;
	}


	public String getReply() {
		return reply;
	}


	public void setReply(String reply) {
		this.reply = reply;
	}


	@Override
	public String toString() {
		return "Ask [askNo=" + askNo + ", askSubject=" + askSubject + ", askContents=" + askContents
				+ ", answerContents=" + answerContents + ", askDate=" + askDate + ", answerDate=" + answerDate
				+ ", userId=" + userId + ", disclosure=" + disclosure + ", reply=" + reply + "]";
	}

	
	
	
	
	

}
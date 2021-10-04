package manager.ask.model.vo;

import java.util.Date;

public class M_ask {

	private int askNo;
	private String askSub;
	private String askCon;
	private String answerCon;
	private Date askDate;
	private Date answerDate;
	private String userId;
	private char disclosure;
	private char reply;
	
	public M_ask() {}

	public M_ask(String aSub, String aCon, String awCon, int aNo) {
		super();
		this.askSub = aSub;
		this.askCon = aCon;
		this.answerCon = awCon;
		this.askNo = aNo;
	}





	public int getAskNo() {
		return askNo;
	}

	public void setAskNo(int askNo) {
		this.askNo = askNo;
	}

	public String getAskSub() {
		return askSub;
	}

	public void setAskSub(String askSub) {
		this.askSub = askSub;
	}

	public String getAskCon() {
		return askCon;
	}

	public void setAskCon(String askCon) {
		this.askCon = askCon;
	}

	public String getAnswerCon() {
		return answerCon;
	}

	public void setAnswerCon(String answerCon) {
		this.answerCon = answerCon;
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

	public char getDisclosure() {
		return disclosure;
	}

	public void setDisclosure(char disclosure) {
		this.disclosure = disclosure;
	}

	public char getReply() {
		return reply;
	}

	public void setReply(char reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "M_askList [askNo=" + askNo + ", askSub=" + askSub + ", askCon=" + askCon + ", answerCon=" + answerCon
				+ ", askDate=" + askDate + ", answerDate=" + answerDate + ", userId=" + userId + ", disclosure="
				+ disclosure + ", reply=" + reply + "]";
	}
	
	
}

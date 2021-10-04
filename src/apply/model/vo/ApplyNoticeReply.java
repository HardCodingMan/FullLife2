package apply.model.vo;

import java.sql.Date;

public class ApplyNoticeReply {
	
	private int replyNo;
	private String replyUserId;
	private String replyContents;
	private Date replyDate;
	private int noticeNo;
	private int countReply;
	
	public ApplyNoticeReply() {};
	
	public ApplyNoticeReply(int replyNo, String replyUserId, String replyContents, Date replyDate, int noticeNo) {
		super();
		this.replyNo = replyNo;
		this.replyUserId = replyUserId;
		this.replyContents = replyContents;
		this.replyDate = replyDate;
		this.noticeNo = noticeNo;
	}

	public int getCountReply() {
		return countReply;
	}

	public void setCountReply(int countReply) {
		this.countReply = countReply;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	@Override
	public String toString() {
		return "ApplyNoticeReply [replyNo=" + replyNo + ", replyUserId=" + replyUserId + ", replyContents="
				+ replyContents + ", replyDate=" + replyDate + ", noticeNo=" + noticeNo + "]";
	}
	
}

package apply.model.vo;

import java.sql.Date;
import java.util.List;


public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContents;
	private int views;
	private Date enrollDate;
	private int noticeLike;
	private int nowSupport;
	private int needSupport;
	private int supportHuman;
	private String picPath;
	private long picSize;
	private String picName;
	private char levelCheck;
	private String userId;
		// 댓글
		private List<ApplyNoticeReply> replist;
		
		public Notice(List<ApplyNoticeReply> replist) {
			super();
			this.replist = replist;
		}
		
		public List<ApplyNoticeReply> getReplist(){
			return replist;
		}
		
		public void setReplist(List<ApplyNoticeReply> replist) {
			this.replist = replist;
		}
	
	public Notice() {}


	public Notice(int noticeNo, String noticeTitle, String noticeContents, int views, Date enrollDate, int noticeLike,
			int nowSupport, int needSupport, int supportHuman, String picPath, long picSize, String picName,
			char levelCheck, String userId, List<ApplyNoticeReply> replist) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.views = views;
		this.enrollDate = enrollDate;
		this.noticeLike = noticeLike;
		this.nowSupport = nowSupport;
		this.needSupport = needSupport;
		this.supportHuman = supportHuman;
		this.picPath = picPath;
		this.picSize = picSize;
		this.picName = picName;
		this.levelCheck = levelCheck;
		this.userId = userId;
		this.replist = replist;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getNoticeLike() {
		return noticeLike;
	}

	public void setNoticeLike(int noticeLike) {
		this.noticeLike = noticeLike;
	}

	public int getNowSupport() {
		return nowSupport;
	}

	public void setNowSupport(int nowSupport) {
		this.nowSupport = nowSupport;
	}

	public int getNeedSupport() {
		return needSupport;
	}

	public void setNeedSupport(int needSupport) {
		this.needSupport = needSupport;
	}

	public int getSupportHuman() {
		return supportHuman;
	}

	public void setSupportHuman(int supportHuman) {
		this.supportHuman = supportHuman;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public long getPicSize() {
		return picSize;
	}

	public void setPicSize(long picSize) {
		this.picSize = picSize;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public char getLevelCheck() {
		return levelCheck;
	}

	public void setLevelCheck(char levelCheck) {
		this.levelCheck = levelCheck;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContents=" + noticeContents
				+ ", views=" + views + ", enrollDate=" + enrollDate + ", noticeLike=" + noticeLike + ", nowSupport="
				+ nowSupport + ", needSupport=" + needSupport + ", supportHuman=" + supportHuman + ", picPath="
				+ picPath + ", picSize=" + picSize + ", picName=" + picName + ", levelCheck=" + levelCheck + ", userId="
				+ userId + ", replist=" + replist + "]";
	}

	
	
	

}

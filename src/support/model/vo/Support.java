package support.model.vo;

import java.sql.Date;

public class Support {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContents;
	private int views;
	private Date enrollDate;
	private int nowSupport;
	private int needSupport;
	private int supportHuman;
	private String picPath;
	private double picSize;
	private String userId;
	private int percentage;
	
	public Support() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getPercentage() {
		return percentage;
	}



	public void setPercentage(int percentage) {
		this.percentage = percentage;
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

	public double getPicSize() {
		return picSize;
	}

	public void setPicSize(double picSize) {
		this.picSize = picSize;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Support [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContents=" + noticeContents
				+ ", views=" + views + ", enrollDate=" + enrollDate + ", nowSupport=" + nowSupport + ", needSupport="
				+ needSupport + ", supportHuman=" + supportHuman + ", picPath=" + picPath + ", picSize=" + picSize
				+ ", userId=" + userId + "]";
	}
	
}

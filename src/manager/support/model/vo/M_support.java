package manager.support.model.vo;

import java.util.Date;
import java.util.List;

public class M_support {

	private int notiNo;
	private String notiTitle;
	private String notiCon;
	private int views;
	private Date enroll;
	private int notiLike;
	private int nowSup;
	private int needSup;
	private int supHuman;
	private String picPath;
	private long picSize;
	private String picName;
	private char level;
	private String userId;
	//댓글
	private List<M_supReply> replies;
	
	
	public M_support() {}

	
	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	public String getNotiTitle() {
		return notiTitle;
	}

	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}

	public String getNotiCon() {
		return notiCon;
	}

	public void setNotiCon(String notiCon) {
		this.notiCon = notiCon;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getEnroll() {
		return enroll;
	}

	public void setEnroll(Date enroll) {
		this.enroll = enroll;
	}

	public int getNotiLike() {
		return notiLike;
	}

	public void setNotiLike(int notiLike) {
		this.notiLike = notiLike;
	}

	public int getNowSup() {
		return nowSup;
	}

	public void setNowSup(int nowSup) {
		this.nowSup = nowSup;
	}

	public int getNeedSup() {
		return needSup;
	}

	public void setNeedSup(int needSup) {
		this.needSup = needSup;
	}

	public int getSupHuman() {
		return supHuman;
	}

	public void setSupHuman(int supHuman) {
		this.supHuman = supHuman;
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

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	public List<M_supReply> getReplies() {
		return replies;
	}


	public void setReplies(List<M_supReply> replies) {
		this.replies = replies;
	}


	@Override
	public String toString() {
		return "M_support [notiNo=" + notiNo + ", notiTitle=" + notiTitle + ", notiCon=" + notiCon + ", views=" + views
				+ ", enroll=" + enroll + ", notiLike=" + notiLike + ", nowSup=" + nowSup + ", needSup=" + needSup
				+ ", supHuman=" + supHuman + ", picPath=" + picPath + ", picSize=" + picSize + ", picName=" + picName
				+ ", level=" + level + ", userId=" + userId + ", replies=" + replies + "]";
	}
	
	
}

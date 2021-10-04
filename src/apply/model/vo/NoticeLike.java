package apply.model.vo;

public class NoticeLike {

	private int noticeLike;
	private int noticeNo;
	private String userId;
	private int likeCheck;
	public NoticeLike() {};
	public NoticeLike(int noticeLike, int noticeNo, String userId, int likeCheck) {
		super();
		this.noticeLike = noticeLike;
		this.noticeNo = noticeNo;
		this.userId = userId;
		this.likeCheck = likeCheck;
	}
	public int getNoticeLike() {
		return noticeLike;
	}
	public void setNoticeLike(int noticeLike) {
		this.noticeLike = noticeLike;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getLikeCheck() {
		return likeCheck;
	}
	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}
	@Override
	public String toString() {
		return "NoticeLike [noticeLike=" + noticeLike + ", noticeNo=" + noticeNo + ", userId=" + userId + ", likeCheck="
				+ likeCheck + "]";
	}
	
	
}

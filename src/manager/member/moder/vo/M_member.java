package manager.member.moder.vo;

import java.util.Date;

public class M_member {

	private String userId;
	private int userNo;
	private String userPwd;
	private String userName;
	private String zumin;
	private String addr;
	private String phone;
	private Date regDate;
	private String enrolled;
	private int totalPoint;
	private String email;
	
	
	public M_member() {}



	public M_member(String mId, String mPwd, String mName, String mZumin, String mAddr, String mPhone, int mPoint,String mEmail) {
		super();
		this.userId = mId;
		this.userPwd = mPwd;
		this.userName = mName;
		this.zumin = mZumin;
		this.addr = mAddr;
		this.phone = mPhone;
		this.totalPoint = mPoint;
		this.email = mEmail;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getUserNo() {
		return userNo;
	}



	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}



	public String getUserPwd() {
		return userPwd;
	}



	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getZumin() {
		return zumin;
	}



	public void setZumin(String zumin) {
		this.zumin = zumin;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public String getEnrolled() {
		return enrolled;
	}



	public void setEnrolled(String enrolled) {
		this.enrolled = enrolled;
	}



	public int getTotalPoint() {
		return totalPoint;
	}



	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "M_member [userId=" + userId + ", userNo=" + userNo + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", zumin=" + zumin + ", addr=" + addr + ", phone=" + phone + ", regDate=" + regDate + ", enrolled="
				+ enrolled + ", totalPoint=" + totalPoint + ", email=" + email + "]";
	}




	
	
}

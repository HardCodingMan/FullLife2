package mypage.model.vo;

import java.sql.Date;

public class BookedHospitalInfo {
	
	private String userId;
	private int hospitalNo;
	private int organNo;
	private Date HospitalTime;
	private String hospitalAddr;
	private String hospitalName;
	private String organ;
	private String checkDate;
	
	public BookedHospitalInfo () {}

	public BookedHospitalInfo(String userId, int hospitalNo, int organNo, Date hospitalTime) {
		super();
		this.userId = userId;
		this.hospitalNo = hospitalNo;
		this.organNo = organNo;
		HospitalTime = hospitalTime;
	}
	
	public String getHospitalAddr() {
		return hospitalAddr;
	}

	public void setHospitalAddr(String hospitalAddr) {
		this.hospitalAddr = hospitalAddr;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public int getOrganNo() {
		return organNo;
	}

	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}

	public Date getHospitalTime() {
		return HospitalTime;
	}

	public void setHospitalTime(Date hospitalTime) {
		HospitalTime = hospitalTime;
	}

	@Override
	public String toString() {
		return "BookedHospitalInfo [userId=" + userId + ", hospitalNo=" + hospitalNo + ", organNo=" + organNo
				+ ", HospitalTime=" + HospitalTime + "]";
	}
	
	
	

}

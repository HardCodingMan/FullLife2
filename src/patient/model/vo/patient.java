package patient.model.vo;

import java.sql.Date;

public class patient {
	private String patientName;
	private String patientAddr;
	private String patientPhone;
	private String relation;
	private String patientZumin;
	private int organNo;
	private Date hospitalTime;
	private int hospitalNo;
	private String userId;
	private int historyNo;
	
	public patient() {}

	
	
	public patient(String patientName, String patientAddr, String patientPhone, String relation, String patientZumin,
			int organNo, Date hospitalTime, int hospitalNo, String userId, int historyNo) {
		super();
		this.patientName = patientName;
		this.patientAddr = patientAddr;
		this.patientPhone = patientPhone;
		this.relation = relation;
		this.patientZumin = patientZumin;
		this.organNo = organNo;
		this.hospitalTime = hospitalTime;
		this.hospitalNo = hospitalNo;
		this.userId = userId;
		this.historyNo = historyNo;
	}



	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddr() {
		return patientAddr;
	}

	public void setPatientAddr(String patientAddr) {
		this.patientAddr = patientAddr;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPatientZumin() {
		return patientZumin;
	}

	public void setPatientZumin(String patientZumin) {
		this.patientZumin = patientZumin;
	}

	public int getOrganNo() {
		return organNo;
	}

	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}

	public Date getHospitalTime() {
		return hospitalTime;
	}

	public void setHospitalTime(Date hospitalTime) {
		this.hospitalTime = hospitalTime;
	}

	public int getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	@Override
	public String toString() {
		return "환자이름=" + patientName + ", 주소=" + patientAddr + ", 전화번호=" + patientPhone
				+ ", 구매자와의관계=" + relation + ", 환자주민번호=" + patientZumin + ", 장기식별번호=" + organNo
				+ ", 병원예약시간=" + hospitalTime + ", 병원고유번호=" + hospitalNo + ", 아이디=" + userId
				+ ", 주문번호=" + historyNo;
	}
	
	

}
	
	


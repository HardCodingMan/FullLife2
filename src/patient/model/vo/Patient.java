package patient.model.vo;

import java.util.Date;

public class Patient {
	private int resultNo;
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
	
	public Patient() {}
	
	

	public Patient(int resultNo, String patientName, String patientAddr, String patientPhone, String relation,
			String patientZumin, int organNo, Date hospitalTime, int hospitalNo, String userId, int historyNo) {
		super();
		this.resultNo = resultNo;
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



	public int getResultNo() {
		return resultNo;
	}

	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
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
		return "????????????=" + resultNo + ", ????????????=" + patientName + ", ????????????=" + patientAddr
				+ ", ???????????????=" + patientPhone + ", ?????????????????????=" + relation + ", ??????????????????=" + patientZumin
				+ ", ??????????????????=" + organNo + ", ??????????????????=" + hospitalTime + ", ??????????????????=" + hospitalNo + ", ???????????????="
				+ userId + ", ????????????=" + historyNo;
	}


	

}
	
	


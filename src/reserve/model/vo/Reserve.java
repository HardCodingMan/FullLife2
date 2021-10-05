package reserve.model.vo;

import java.sql.Date;

public class Reserve {
	private int resultNo;
	private String patientName;
	private int patientZumin;
	private String patientPhone;
	private String patientAddr;
	private String relation;
	private int organNo;
	private Date hospitalTime;
	private int hospitalNo;
	private String userId;
	
	public Reserve() {}

	public Reserve(int resultNo, String patientName, int patientZumin, String patientPhone, String patientAddr,
			String relation, int organNo, Date hospitalTime, int hospitalNo, String userId) {
		super();
		this.resultNo = resultNo;
		this.patientName = patientName;
		this.patientZumin = patientZumin;
		this.patientPhone = patientPhone;
		this.patientAddr = patientAddr;
		this.relation = relation;
		this.organNo = organNo;
		this.hospitalTime = hospitalTime;
		this.hospitalNo = hospitalNo;
		this.userId = userId;
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

	public int getPatientZumin() {
		return patientZumin;
	}

	public void setPatientZumin(int patientZumin) {
		this.patientZumin = patientZumin;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientAddr() {
		return patientAddr;
	}

	public void setPatientAddr(String patientAddr) {
		this.patientAddr = patientAddr;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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

	@Override
	public String toString() {
		return "Reserve [resultNo=" + resultNo + ", patientName=" + patientName + ", patientZumin=" + patientZumin
				+ ", patientPhone=" + patientPhone + ", patientAddr=" + patientAddr + ", relation=" + relation
				+ ", organNo=" + organNo + ", hospitalTime=" + hospitalTime + ", hospitalNo=" + hospitalNo + ", userId="
				+ userId + "]";
	}
	
	
}
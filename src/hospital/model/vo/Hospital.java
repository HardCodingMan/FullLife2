package hospital.model.vo;

public class Hospital {
	private int hospitalNo;
	private String hospitalName;
	private String hospitalAddr;
	private String hospitalPhone;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	
	public Hospital(int hospitalNo, String hospitalName, String hospitalAddr, String hospitalPhone) {
		super();
		this.hospitalNo = hospitalNo;
		this.hospitalName = hospitalName;
		this.hospitalAddr = hospitalAddr;
		this.hospitalPhone = hospitalPhone;
	}

	public int getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(int hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddr() {
		return hospitalAddr;
	}

	public void setHospitalAddr(String hospitalAddr) {
		this.hospitalAddr = hospitalAddr;
	}

	public String getHospitalPhone() {
		return hospitalPhone;
	}

	public void setHospitalPhone(String hospitalPhone) {
		this.hospitalPhone = hospitalPhone;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalNo=" + hospitalNo + ", hospitalName=" + hospitalName + ", hospitalAddr="
				+ hospitalAddr + ", hospitalPhone=" + hospitalPhone + "]";
	}
	
	

}

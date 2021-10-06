package mypage.model.vo;

import java.sql.Date;

public class History {
	private int historyNo;
	private int organNo;
	private int organQuantity;
	private Date historyDate;
	private int payment;
	private Date paymentDate;
	private int usedPoint;
	private String userId;
	private int hospitalNo;
	private String hospitalName;
	
	public History() {}
	


	public History(int historyNo, int organNo, int organQuantity, Date historyDate, int payment, Date paymentDate,
			int usedPoint, String userId, int hospitalNo, String hospitalName) {
		super();
		this.historyNo = historyNo;
		this.organNo = organNo;
		this.organQuantity = organQuantity;
		this.historyDate = historyDate;
		this.payment = payment;
		this.paymentDate = paymentDate;
		this.usedPoint = usedPoint;
		this.userId = userId;
		this.hospitalNo = hospitalNo;
		this.hospitalName = hospitalName;
	}



	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	public int getOrganNo() {
		return organNo;
	}

	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}

	public int getOrganQuantity() {
		return organQuantity;
	}

	public void setOrganQuantity(int organQuantity) {
		this.organQuantity = organQuantity;
	}

	public Date getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
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

	
	public String getHospitalName() {
		return hospitalName;
	}



	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}



	@Override
	public String toString() {
		return "History [historyNo=" + historyNo + ", organNo=" + organNo + ", organQuantity=" + organQuantity
				+ ", historyDate=" + historyDate + ", payment=" + payment + ", paymentDate=" + paymentDate
				+ ", usedPoint=" + usedPoint + ", userId=" + userId + ", hospitalNo=" + hospitalNo + ", hospitalName="
				+ hospitalName + "]";
	}



	
}

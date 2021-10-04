package manager.order.model.vo;

import java.util.Date;

public class M_order {

	private int historyNo;
	private int organNo;
	private int organQuan;
	private Date historyDate;
	private int payment;
	private Date payDate;
	private int usedPoint;
	private String userId;
	private int hospitalNo;
	
	public M_order() {}

	
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

	public int getOrganQuan() {
		return organQuan;
	}

	public void setOrganQuan(int organQuan) {
		this.organQuan = organQuan;
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

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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

	@Override
	public String toString() {
		return "M_order [historyNo=" + historyNo + ", organNo=" + organNo + ", organQuan=" + organQuan
				+ ", historyDate=" + historyDate + ", payment=" + payment + ", payDate=" + payDate + ", usedPoint="
				+ usedPoint + ", userId=" + userId + ", hospitalNo=" + hospitalNo + "]";
	}
	
	
}

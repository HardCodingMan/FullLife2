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
	
	public History() {}
	
	public History(int historyNo, int organNo, int organQuantity, Date historyDate, int payment, Date paymentDate,
			int usedPoint, String userId, int hospitalNo) {
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

	@Override
	public String toString() {
		return "주문번호=" + historyNo + ", 장기식별번호=" + organNo + ", 주문수량=" + organQuantity
				+ ", 주문날짜=" + historyDate + ", 결제금액=" + payment + ", 결제날짜=" + paymentDate
				+ ", 사용된포인트=" + usedPoint + ", 회원아이디=" + userId + ", 병원고유번호=" + hospitalNo;
	}
}

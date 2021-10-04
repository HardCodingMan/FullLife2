package manager.support.model.vo;

import java.util.Date;

public class M_supReply {

	private int supReNo;
	private String reUserId;
	private String supReCon;
	private Date supReDate;
	private int notiNo;
	
	public M_supReply() {}

	public int getSupReNo() {
		return supReNo;
	}

	public void setSupReNo(int supReNo) {
		this.supReNo = supReNo;
	}

	public String getReUserId() {
		return reUserId;
	}

	public void setReUserId(String reUserId) {
		this.reUserId = reUserId;
	}

	public String getSupReCon() {
		return supReCon;
	}

	public void setSupReCon(String supReCon) {
		this.supReCon = supReCon;
	}

	public Date getSupReDate() {
		return supReDate;
	}

	public void setSupReDate(Date supReDate) {
		this.supReDate = supReDate;
	}

	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	@Override
	public String toString() {
		return "M_supReply [supReNo=" + supReNo + ", reUserId=" + reUserId + ", supReCon=" + supReCon + ", supReDate="
				+ supReDate + ", notiNo=" + notiNo + "]";
	}
	
	
}

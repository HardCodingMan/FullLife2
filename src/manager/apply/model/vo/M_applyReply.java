package manager.apply.model.vo;

import java.util.Date;

public class M_applyReply {
	
	private int apReNo;
	private String reUserId;
	private String apReCon;
	private Date apReDate;
	private int notiNo;

	
	public M_applyReply() {}
	
	public int getApReNo() {
		return apReNo;
	}
	public void setApReNo(int apReNo) {
		this.apReNo = apReNo;
	}
	public String getReUserId() {
		return reUserId;
	}
	public void setReUserId(String reUserId) {
		this.reUserId = reUserId;
	}
	public String getApReCon() {
		return apReCon;
	}
	public void setApReCon(String apReCon) {
		this.apReCon = apReCon;
	}
	public Date getApReDate() {
		return apReDate;
	}
	public void setApReDate(Date apReDate) {
		this.apReDate = apReDate;
	}
	public int getNotiNo() {
		return notiNo;
	}
	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}


	@Override
	public String toString() {
		return "M_applyReply [apReNo=" + apReNo + ", userId=" + reUserId + ", apReCon=" + apReCon + ", apReDate="
				+ apReDate + ", notiNo=" + notiNo +"]";
	}
	
	
	
	

}

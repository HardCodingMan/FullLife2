package manager.login.model.vo;

public class M_Login_Admin {
	
	private String adminId;
	private int adminNo;
	private String adminPwd;
	
	public M_Login_Admin() {}
	
	

	public M_Login_Admin(String adminId, int adminNo, String adminPwd) {
		super();
		this.adminId = adminId;
		this.adminNo = adminNo;
		this.adminPwd = adminPwd;
	}



	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override
	public String toString() {
		return "M_Login_Admin [adminId=" + adminId + ", adminNo=" + adminNo + ", adminPwd=" + adminPwd + "]";
	}
	
	


}

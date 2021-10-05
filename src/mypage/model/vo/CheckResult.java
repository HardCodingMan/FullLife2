package mypage.model.vo;

import java.sql.Date;

public class CheckResult {
	private int fileNo;
	private String fileName;
	private String filePath;
	private int fileSize;
	private Date checkDate;
	private String userId;
	private int hospitalNo;
	private String hospitalName;

	
	public CheckResult() {}
	
	


	public CheckResult(int fileNo, String fileName, String filePath, int fileSize, Date checkDate, String userId,
			int hospitalNo, String hospitalName) {
		super();
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.checkDate = checkDate;
		this.userId = userId;
		this.hospitalNo = hospitalNo;
		this.hospitalName = hospitalName;
	}




	public int getFileNo() {
		return fileNo;
	}


	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public int getFileSize() {
		return fileSize;
	}


	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}


	public Date getCheckDate() {
		return checkDate;
	}


	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
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
		return "CheckResult [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + ", checkDate=" + checkDate + ", userId=" + userId + ", hospitalNo=" + hospitalNo
				+ ", hospitalName=" + hospitalName + "]";
	}
	
	




}

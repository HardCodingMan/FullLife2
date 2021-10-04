package manager.result.model.vo;

public class M_result {

	private int resultNo;
	private String fileName;
	private String filePath;
	private double fileSize;
	private String checkDate;
	private String userId;
	private int hospitalNo;
	
	public M_result() {}

	public int getResultNo() {
		return resultNo;
	}

	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
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

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
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

	@Override
	public String toString() {
		return "M_result [resultNo=" + resultNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + ", checkDate=" + checkDate + ", userId=" + userId + ", hospitalNo=" + hospitalNo + "]";
	}
	
	
	
}

package manager.result.model.vo;

import java.util.Date;
import java.util.List;

public class M_patient {

	private int resultNo;
	private String pName;
	private String pZumin;
	private int hosNo;
	private String userId;
	private int fileNo;
	private String fileName;
	private String filePath;
	private Long fileSize;
	private String checkDate;
	
	public M_patient() {}

	public int getResultNo() {
		return resultNo;
	}

	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpZumin() {
		return pZumin;
	}

	public void setpZumin(String pZumin) {
		this.pZumin = pZumin;
	}

	public int getHosNo() {
		return hosNo;
	}

	public void setHosNo(int hosNo) {
		this.hosNo = hosNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public String toString() {
		return "M_patient [resultNo=" + resultNo + ", pName=" + pName + ", pZumin=" + pZumin + ", hosNo=" + hosNo
				+ ", userId=" + userId + ", fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath
				+ ", fileSize=" + fileSize + ", checkDate=" + checkDate + "]";
	}

	

}

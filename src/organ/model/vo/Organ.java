package organ.model.vo;

public class Organ {
	private int organNo;
	private String organName;
	private int organPrice;
	
	public Organ() {}
	
	public Organ(int organNo, String organName, int organPrice) {
		super();
		this.organNo = organNo;
		this.organName = organName;
		this.organPrice = organPrice;
	}

	public int getOrganNo() {
		return organNo;
	}

	public void setOrganNo(int organNo) {
		this.organNo = organNo;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public int getOrganPrice() {
		return organPrice;
	}

	public void setOrganPrice(int organPrice) {
		this.organPrice = organPrice;
	}

	@Override
	public String toString() {
		return "Organ [organNo=" + organNo + ", organName=" + organName + ", organPrice=" + organPrice + "]";
	}
	
	
}

package mypage.model.vo;

import java.util.List;

public class CheckResultPage {
	private List<CheckResult> cList;
	private String respageNavi;
	
	public CheckResultPage() {}

	public List<CheckResult> getcList() {
		return cList;
	}

	public void setcList(List<CheckResult> cList) {
		this.cList = cList;
	}

	public String getPageNavi() {
		return respageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.respageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "CheckResultPage [cList=" + cList + ", pageNavi=" + respageNavi + "]";
	}
	
	
	
}

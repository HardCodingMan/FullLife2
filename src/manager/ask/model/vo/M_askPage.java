package manager.ask.model.vo;

import java.util.List;

public class M_askPage {

	private List<M_ask> aPdList;
	private String PageNavi;
	
	public M_askPage() {}

	public List<M_ask> getaPdList() {
		return aPdList;
	}

	public void setaPdList(List<M_ask> aPdList) {
		this.aPdList = aPdList;
	}

	public String getPageNavi() {
		return PageNavi;
	}

	public void setPageNavi(String pageNavi) {
		PageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "M_askPage [aPdList=" + aPdList + ", PageNavi=" + PageNavi + "]";
	}
	
	
}

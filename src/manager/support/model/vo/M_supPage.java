package manager.support.model.vo;

import java.util.List;

public class M_supPage {

	private List<M_support> sList;
	private String pageNavi;
	
	
	public M_supPage() {}

	
	public List<M_support> getsList() {
		return sList;
	}

	public void setsList(List<M_support> sList) {
		this.sList = sList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "M_supPage [sList=" + sList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}

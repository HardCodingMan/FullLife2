package mypage.model.vo;

import java.util.List;


public class HistoryPage {
	private List<History> hList;
	private String pageNavi;
	
	public HistoryPage() {}

	public List<History> gethList() {
		return hList;
	}

	public void sethList(List<History> hList) {
		this.hList = hList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "HistoryPage [hList=" + hList + ", pageNavi=" + pageNavi + "]";
	}
 
	

	

}

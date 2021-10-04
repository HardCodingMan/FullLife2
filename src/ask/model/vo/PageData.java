package ask.model.vo;

import java.util.List;

public class PageData {
	private List<Ask> askList;
	private String pageNavi;
	
	public PageData() {}

	public List<Ask> getAskList() {
		return askList;
	}

	public void setAskList(List<Ask> askList) {
		this.askList = askList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "PageData [askList=" + askList + ", pageNavi=" + pageNavi + "]";
	}
	
}

package manager.apply.model.vo;

import java.util.List;

public class M_applyPage {

	private List<M_apply> apList;
	private String pageNavi;
	
	
	public List<M_apply> getApList() {
		return apList;
	}
	public void setApList(List<M_apply> apList) {
		this.apList = apList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
	@Override
	public String toString() {
		return "M_applyPage [apList=" + apList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}

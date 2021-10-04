package manager.member.moder.vo;

import java.util.List;

public class M_PageData {

	private List<M_member> memList;
	private String pageNavi;
	
	public M_PageData() {}

	public List<M_member> getMemList() {
		return memList;
	}

	public void setMemList(List<M_member> memList) {
		this.memList = memList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "m_PageData [memList=" + memList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}

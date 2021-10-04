package manager.order.model.vo;

import java.util.List;

public class M_orderPage {

	private List<M_order> opList;
	private String pageNavi;
	
	public M_orderPage () {}
	
	public List<M_order> getOpList() {
		return opList;
	}
	public void setOpList(List<M_order> opList) {
		this.opList = opList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "M_orderPage [opList=" + opList + ", pageNavi=" + pageNavi + "]";
	}
	
	
	
}

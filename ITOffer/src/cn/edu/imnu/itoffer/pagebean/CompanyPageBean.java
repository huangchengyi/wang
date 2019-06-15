package cn.edu.imnu.itoffer.pagebean;

import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.itoffter.dao.CompanyDAO;
import cn.edu.imnu.itoffter.info.Company;

public class CompanyPageBean {
	private int pageSize = 10;
	private int pageNo = 1;
	private int totalPages;
	private List<Company> pageData = new ArrayList<Company>();
	private boolean hasNextPage;
	private boolean hasPreviousPage;
	
	public int getTotalPages() {
		CompanyDAO dao = new CompanyDAO();
		int recordCount = dao.getRecordCount();
		return(recordCount + pageSize - 1) / pageSize;
	}
	public List<Company>getPageData(){
		CompanyDAO dao = new CompanyDAO();
		List<Company>list = dao.getCompanyPageList(pageNo, pageSize);
		return list;
	}
	public boolean isHasNextPage() {
		return (this.getPageNo()<this.getTotalPages());
	}
	public boolean isHasPreviousPage() {
		return(this.getPageNo()>1);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setPageData(List<Company> pageData) {
		this.pageData = pageData;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	

}

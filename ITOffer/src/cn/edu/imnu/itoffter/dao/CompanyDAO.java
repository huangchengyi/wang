package cn.edu.imnu.itoffter.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.imnu.itoffer.util.DBUtil;
import cn.edu.imnu.itoffter.info.Company;
import cn.edu.imnu.itoffter.info.Job;

public class CompanyDAO {
	public List<Company>getCompanyList(){
		List<Company>list = new ArrayList<Company>();
		String sql = "SELECT tb_company.company_id,company_pic,job_id,job_name,job_salary,job_area,job_endtime" + 
		             " FROM tb_company LEFT OUTER JOIN tb_job ON tb_job.COMPANY_ID=tb_company.COMPANY_ID" + 
				     " WHERE company_state=1 AND job_id IN" + 
		             "(SELECT MAX(job_id) FROM tb_job WHERE job_state=1 GROUP BY company_id)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Company company = new Company();
				Job job = new Job();
				
				company.setCompanyId(rs.getInt("company_Id"));
				company.setCompanyPic(rs.getString("company_pic"));
				job.setJobId(rs.getInt("job_id"));
				job.setJobName(rs.getString("job_name"));
				job.setJobSalary(rs.getString("job_salary"));
				job.setJobArea(rs.getString("job_area"));
				job.setJobEnddate(rs.getDate("job_endtime"));
				company.getJobs().add(job);
				list.add(company);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
		             
	}
	public List<Company> getCompanyPageList(int pageNo, int pageSize){
		int firstIndex = pageSize * (pageNo - 1);
		List<Company>list = new ArrayList<Company>();
		String sql = "SELECT tb_company.COMPANY_ID,company_pic,job_id,job_name,job_salary,job_area,job_endtime" + 
		             "FROM tb_company LEFT OUTER JOIN tb_job ON tb_job.COMPANY_ID=tb_company.COMPANY_ID" + 
				     "WHERE company_state=1 AND job_id IN" + 
		             "(SELECT MAX(job_id) FROM tb_job WHERE job_state=1 GROUP BY company_id" + 
				     "limit ?, ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstIndex);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Company company = new Company();
				Job job = new Job();
				
				company.setCompanyId(rs.getInt("company_Id"));
				company.setCompanyPic(rs.getString("company_pic"));
				job.setJobId(rs.getInt("job_id"));
				job.setJobName(rs.getString("job_name"));
				job.setJobSalary(rs.getString("job_salary"));
				job.setJobArea(rs.getString("job_area"));
				job.setJobEnddate(rs.getDate("job_endtime"));
				company.getJobs().add(job);
				list.add(company);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
	public int getRecordCount() {
		int recordCount= 0;
		String sql = "SELECT count(*) FROM tb_company LEFT OUTER JOIN tb_job ON tb_job.COMPANY_ID=tb_company.COMPANY_ID" + 
		             "WHERE company_state=1 AND job_id IN" + 
				     "(SELECT MAX(job_id) FROM tb_job WHERE job_state=1 GROUP BY company_id)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recordCount = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return recordCount;
	}

}

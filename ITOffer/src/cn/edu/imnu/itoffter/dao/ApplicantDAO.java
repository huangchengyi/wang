package cn.edu.imnu.itoffter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import cn.edu.imnu.itoffer.util.DBUtil;

public class ApplicantDAO {

	public boolean isExistEmail(String email) {
		String sql = "select * from tb_applicant where applient_email = ?";
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			result = pstmt.executeQuery();
			if(result.next()) {
				return true;
			}
		}catch  (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(result, pstmt, conn);
		}
		
		return false;
	}

	public void save(String email, String password) {
		String sql = "insert into tb_applicant(applicant_email,applicant_pwd,applicant_registdate) values(?, ?, ?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
	}
	public int login(String email, String password) {
		int applicantID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "SELECT applicant_id FROM tb_applicant WHERE applicant_email = ? and applicant_pwd = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			result = pstmt.executeQuery();
			if (result.next())
				applicantID = result.getInt("applicant_id");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(result, pstmt, conn);
		}
		return applicantID;
	}
	public int isExistResume(int applicantID) {
		int resumeID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "SELECT basicinfo_id FROM tb_resume_basicinfo WHERE applicant_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, applicantID);
			result = pstmt.executeQuery();
			if(result.next())
				resumeID = result.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(result, pstmt, conn);
		}
		return resumeID;
	}

}


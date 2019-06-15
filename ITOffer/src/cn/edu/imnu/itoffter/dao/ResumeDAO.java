package cn.edu.imnu.itoffter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import cn.edu.imnu.itoffer.util.DBUtil;
import cn.edu.imnu.itoffter.info.ResumeBasicinfo;

public class ResumeDAO {
	public int add(ResumeBasicinfo basicinfo, int applicantID) {
		// TODO Auto-generated method stub
		int basicinfoID = 0;
		String sql = "INSERT INTO tb_resume_basicinfo(realname,gender,birthday,telephone,email,job_intension,job_experience,head_shot,applicant_id)VALUES(?,?,?,?,?,?,?,'QST.jpg',?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			System.out.println(applicantID);
			//conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, basicinfo.getRealName());
			pstmt.setString(2, basicinfo.getGender());
			pstmt.setString(3, null);
			pstmt.setTimestamp(3, basicinfo.getBirthday() == null ? null : new Timestamp(basicinfo.getBirthday().getTime()));
			pstmt.setString(4, basicinfo.getTelephone());
			pstmt.setString(5, basicinfo.getEmail());
			pstmt.setString(6, basicinfo.getJobIntension());
			pstmt.setString(7, basicinfo.getJobExperience());
			pstmt.setInt(8, applicantID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return basicinfoID;
	}

	public void updateHeadShot(int resumeID, String newFileName) {
		// TODO Auto-generated method stub
		
	}

}


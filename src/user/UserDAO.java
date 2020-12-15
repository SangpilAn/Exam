package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	
	public int login(String userID, String userPassword) {
		String SQL="select userpassword from user where userID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //�α��� ����
				}else {
					return 0; //��й�ȣ Ʋ��
				}
			}
			return -1; //���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn !=null)
					conn.close();
				if(pstmt !=null)
					pstmt.close();
				if(rs !=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -2; //�����ͺ��̽� ����
	}
	
	public int join(UserDTO user) {
		String SQL="insert into user values (?,?,?,?,false)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserEmailHash());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn !=null)
					conn.close();
				if(pstmt !=null)
					pstmt.close();
				if(rs !=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1; //ȸ������ ����
	}
	
	public String getUserEmail(String userID) {
		String SQL="select userEmail from user where userID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn !=null)
					conn.close();
				if(pstmt !=null)
					pstmt.close();
				if(rs !=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null; //�����ͺ��̽� ����
	}
	
	public boolean getUserEmailChecked(String userID) {
		String SQL="select userEmailChecked from user where userID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn !=null)
					conn.close();
				if(pstmt !=null)
					pstmt.close();
				if(rs !=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false; //�����ͺ��̽� ����
	}
	
	public boolean setUserEmailChecked(String userID) {
		String SQL="update user set userEmailChecked=true where userID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn !=null)
					conn.close();
				if(pstmt !=null)
					pstmt.close();
				if(rs !=null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false; //�����ͺ��̽� ����
	}
	
}

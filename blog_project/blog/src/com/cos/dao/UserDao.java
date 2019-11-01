package com.cos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.model.User;
import com.cos.util.DBClose;

public class UserDao {
	// �̱������� ������ �ϴµ� �׳� ��

	private Connection conn; // ����
	private PreparedStatement pstmt; // SQL�� �ۼ�
	private ResultSet rs; // Ŀ��

	public User findByUsername(String username) {

		final String SQL = "SELECT * FROM user WHERE username = ?";

		conn = DBConn.getConnection();

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("createDate"));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return null;

	}

	public int save(User user) {

		conn = DBConn.getConnection();

		final String SQL = "INSERT IGNORE INTO user values(null, ?, ?, ?,now(), ?)";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			int result = pstmt.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return -1;
	}

	public int update(User user) {

		conn = DBConn.getConnection();

		final String SQL = "UPDATE user SET password=?, address=? WHERE id=?";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getAddress());
			pstmt.setInt(3, user.getId());
			int result = pstmt.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return -1;
	}

	/*
	 * �α������� return 1 : ���� return 0 : ������ return -1: DB����
	 * 
	 */
	public int findByUsernameAndPassword(String username, String password) {

		// DB����
		conn = DBConn.getConnection();

		// count(id) ��� ����, �ش��������� select�� �����ϸ� 1�� ���� ����
		final String SQL = "select count(id) from user where username = ? and password = ?";

		try {
			// ���� �ۼ�
			pstmt = conn.prepareStatement(SQL);

			// ���� �ϼ�
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int result = rs.getInt(1);
				return result;
			}

		} catch (Exception e) {
			System.out.println("���̵� �Ǵ� ��й�ȣ ����");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return -1;

	}

}
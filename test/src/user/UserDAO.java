package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int login(String userID, String userPassword) {
		String SQL = "select userPassword from user where userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			System.out.println(pstmt);
			pstmt.setString(1, userID);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1;// �α��� ����
				} else {
					return 0;// ��й�ȣ Ʋ��
				}
			}
			return -1;// ���̵� Ʋ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;// �����ͺ��̽� ����
	}

	public int join(User user) {
		String SQL = "insert into user values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// �����ͺ��̽� ����
	}

}

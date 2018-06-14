package kh.web.message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "kh";
		String pw = "kh";

		Connection con = DriverManager.getConnection(url, id, pw);

		return con;
	}
	
	public int insertData(String name, String msg) throws Exception{
		Connection con = this.getConnection();
		String sql = "insert into messages values((message_seq.nextval,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		
		pstat.setString(1, name);
		pstat.setString(2, msg);
		
		int result = pstat.executeUpdate();
		
		con.commit();
		con.close();
		pstat.close();
		
		return result;
	}
	
	public List<MessageDTO> viewAllData() throws Exception{
		Connection con = this.getConnection();
		String sql = "select * from messages";
		PreparedStatement pstat = con.prepareStatement(sql);
		
		ResultSet rs = pstat.executeQuery();
		List<MessageDTO> result = new ArrayList<>();
		
		while(rs.next()) {
			MessageDTO dto = new MessageDTO();
			
			dto.setSeq(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setMessage(rs.getString(3));
			
			result.add(dto);
		}
		
		con.close();
		pstat.close();
		rs.close();
		
		return result;
	}
	
}

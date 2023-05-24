package hrd_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Dao() {
		try{
			con = getConnection();
		}catch(Exception e) {System.out.println("에러!"+e);}
	}
	//출력하기
	public List<Dto> print_member() {
		
		String sql = " select m.m_no,  m.m_name , p.p_name, m.p_school, m.m_jumin , m.m_city, p.p_tel1 , p.p_tel2, p.p_tel3\r\n"
				+ "  from tbl_member_202005 m join tbl_party_202005  p on m.p_code = p.p_code";
		List<Dto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Dto dto = new Dto( rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6), 
						rs.getString(7),rs.getString(8),rs.getString(9));
				list.add(dto);
			}
			
		} catch (SQLException e) {e.printStackTrace();}
		return list;
	}
	//투표하기
	public boolean vote(Dto dto) {
		String sql ="insert into tbl_vote_202005  values(?,?,?,?,?,?)";
		System.out.println("-------------");
		System.out.println(dto);
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getV_jumin()); ps.setString(2, dto.getV_name());
			ps.setString(3, dto.getM_no()); ps.setString(4, dto.getV_time());
			ps.setString(5, dto.getV_area()); ps.setString(6, dto.getV_confirm());
			ps.executeUpdate(); return true;
		} catch (SQLException e) {e.printStackTrace();}
		return false;
	}
	
	//투표현황
	public List<Dto> voteComfirm(){
		String sql = "select *from tbl_vote_202005 where v_area='제1투표장'";
		List<Dto> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(
						rs.getString(3), rs.getString(1),
						rs.getString(2),rs.getString(4),
						rs.getString(6));
				list.add(dto);
			}return list;
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	//후보자
	public List<Dto> getVoteTop(){
		String sql ="select B.m_no ,  B.m_name, count(*) v_total "
				+ "from tbl_vote_202005 A inner join tbl_member_202005 B "
				+ "on A.m_no = B.m_no "
				+ "where A.v_confirm  = 'Y' "
				+ "group by B.m_no , B.m_name "
				+ "order by v_total DESC";
		List<Dto> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(rs.getString(1), rs.getString(2),rs.getInt(3) );
				list.add(dto);
				
			}
		}catch(Exception e) {System.out.println(e);}
		return list;
	}
	
}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
	}
	//2. sql 조작 인터페이스
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//3. 생성자
	public Dao() {
		try{con = getConnection(); System.out.println("연동성공");
		}catch(Exception e) { System.out.println("실패"+e);}
	}
	
	//4.학생목록 호출
	public List<Dto> getList(){
		List<Dto> list = new ArrayList<>();
		String sql ="select * from student_tbl_03";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5));
					list.add(dto);
			}
		}catch(Exception e) {System.out.println("오류:"+e);}
		return list;
	}
	
	//4-2 점수 등록
	public boolean add(Dto dto) {
		String sql = "insert into exam_tbl_03 values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getSno() );ps.setInt(2, dto.getEkor() );
			ps.setInt(3, dto.getEmath() );ps.setInt(4, dto.getEeng() );
			ps.setInt(5, dto.getEhist() ); ps.executeUpdate(); return true;
		}catch (Exception e) {}
		return false;
	}
	
	//4-3.점수 호출
	public List<Dto> getCreditList(){
		List<Dto> list = new ArrayList<>();
		String sql ="select substr(s.sno,1,1)학년 , substr(s.sno,2,2)반, substr(s.sno,4,5)번호 , s.sname, e.ekor, e.emath, e.eeng, e.ehist , \r\n"
				+ "( e.ekor + e.emath + e.eeng+ e.ehist ) 합계, ( e.ekor + e.emath + e.eeng+ e.ehist )/4 평균, \r\n"
				+ "rank() over(order by ( NVL(e.ekor,0) +NVL( e.emath,0) + NVL(e.eeng,0) + NVL(e.ehist ,0 )  ) desc ) 순위\r\n"
				+ "from exam_tbl_03 e RIGHT OUTER JOIN  student_tbl_03 s \r\n"
				+ "on e.sno = s.sno\r\n"
				+ "order by ( NVL(e.ekor,0) +NVL( e.emath,0) + NVL(e.eeng,0) + NVL(e.ehist ,0 )  ) desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(
						rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),
						rs.getInt(8),rs.getInt(9),rs.getDouble(10),rs.getInt(11) );
					list.add(dto);
			}
		}catch(Exception e) {System.out.println("오류:"+e);}
		return list;
	}
	
}

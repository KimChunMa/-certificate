package controller;

public class Dto {
	private String sno;
	private String sname;
	private String sphone;
	private String sgender;
	private String saddress;
	
	private int ekor;
	private int emath;
	private int eeng;
	private int ehist;
	
	private String grade; //학년
	private String group; // 반 
	private String snumber; // 번호
	
	private int sum;
	private Double avg;
	private int rank;
	
	
	public Dto() {}
	//1. 학생 목록 출력시 사용되는 생성자
	public Dto(String sno, String sname, String sphone, String sgender, String saddress) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
		this.sgender = sgender;
		this.saddress = saddress;
	}
	
	

	public Dto(String sno, int ekor, int emath, int eeng, int ehist) {
		super();
		this.sno = sno;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
	}
	
	public Dto( String grade, String group, String snumber, String sname, 
				int ekor, int emath, int eeng, int ehist, 
				int sum, Double avg, int rank) {
		super();
		this.sname = sname;
		this.ekor = ekor;
		this.emath = emath;
		this.eeng = eeng;
		this.ehist = ehist;
		this.grade = grade;
		this.group = group;
		this.snumber = snumber;
		this.sum = sum;
		this.avg = avg;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Dto [sno=" + sno + ", sname=" + sname + ", sphone=" + sphone + ", sgender=" + sgender + ", saddress="
				+ saddress + "]";
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public String getSgender() {
		return sgender;
	}

	public void setSgender(String sgender) {
		this.sgender = sgender;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public int getEkor() {
		return ekor;
	}
	public void setEkor(int ekor) {
		this.ekor = ekor;
	}
	public int getEmath() {
		return emath;
	}
	public void setEmath(int emath) {
		this.emath = emath;
	}
	public int getEeng() {
		return eeng;
	}
	public void setEeng(int eeng) {
		this.eeng = eeng;
	}
	public int getEhist() {
		return ehist;
	}
	public void setEhist(int ehist) {
		this.ehist = ehist;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}

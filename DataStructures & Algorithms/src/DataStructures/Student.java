package DataStructures;

public class Student {

	private String name;
	private String rollNo;
	private double cgpa;
	
	public Student(String name, String rollNo, double cgpa) {
		this.name = name;
		this.rollNo = rollNo;
		this.cgpa = cgpa;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student name=" + name + ", rollNo=" + rollNo + ", cgpa=" + cgpa;
	}
}

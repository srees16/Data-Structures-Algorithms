package DataStructures;

public class Student {

	public String stuName;
	public Integer rollNo;
	public double cgpa;
	
	public Student(String stuName, Integer rollNo, double cgpa) {
		this.stuName = stuName;
		this.rollNo = rollNo;
		this.cgpa = cgpa;
	}
	
	public String getName() {
		return stuName;
	}
	public void setName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
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
		return "Student name = " + stuName + ", rollNo = " + rollNo + ", cgpa = " + cgpa;
	}
}

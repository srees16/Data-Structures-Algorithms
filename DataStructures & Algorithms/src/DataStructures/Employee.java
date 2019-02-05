package DataStructures;

public class Employee {

	String empName;
	int empId;
	int age;
	
	public Employee() {
		
	}
	
	public Employee(String empName, int empId, int age) {
		this.empId=empId;
		this.empName=empName;
		this.age=age;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Employee " + empName + ", with empId= " + empId + " is of age= " + age+" years";
	}
}
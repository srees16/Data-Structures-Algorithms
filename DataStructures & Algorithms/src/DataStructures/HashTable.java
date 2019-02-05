package DataStructures;

public class HashTable {

	private StudentList[] arr;
	private int size;
	private int totalStudents;
	
	public HashTable() {
		size=1000;
		arr=new StudentList[size];
	}
	
	public int toHashCode(String rollNo) {
		int hash=0;
		int index=0;
		for(int i=0;i<rollNo.length();i++) {
			hash=hash+(int)rollNo.charAt(i);
		}
		index=hash%arr.length;
		return index;
	}
	
	public boolean insert(int key, Student data) {
		if(arr[key]==null) {
			arr[key]=new StudentList();
		}
		arr[key].insertStu(data);
		totalStudents++;
		return true;
	}
	
	public int totalStudents() {
		return totalStudents;
	}
	
	public Student getInfo(String rollNo) {
		int key=toHashCode(rollNo);
		if(arr[key]==null) {
			return null;
		} else {
			Student s=arr[key].getStu(rollNo);
			if(s!=null) {
				return s;
			} else {
				return null;
			}
		}
	}
	
	public boolean deleteStudent(String rollNo) {
		boolean has=arr[toHashCode(rollNo)].ifPresent(rollNo);
		if(has) {
			int key=toHashCode(rollNo);
			arr[key].deleteStu(rollNo);
			totalStudents--;
			return false;
		}
		return false;
	}
	
	public void printAll() {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=null) {
				arr[i].showAll();
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
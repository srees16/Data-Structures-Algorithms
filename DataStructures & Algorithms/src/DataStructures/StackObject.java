package DataStructures;

public class StackObject {

	private int top;
	private Student stack[];
	private int size;
	
	private StackObject() {
		top = -1;
		size = 1;
		stack = new Student[size];
	}
	
	private StackObject(int size) {
		top = 1;
		this.size = size;
		stack = new Student[this.size];
	}
	
	private void reSize() {
		if(isFull()) {
			Student temp[] = stack;
			size *= 2;
			stack = new Student[size];
			for(int i = 0; i <= top; i++) {
				stack[i] = temp[i];
			}
		}
	}
	
	public Student push(Student item) {
		if(!isFull()) {
			top++;
			stack[top] = item;
		} else {
			reSize();
			top++;
			stack[top] = item;
		}
		return item;
	}
	
	public void pop() {
		if(!isEmpty()) {
			Student item = stack[top];
			top--;
		} else {
			throw new IllegalStateException("No elements to pop");
		}
	}
	
	public void peek() {
		System.out.println(stack[top]);
	}
	
	public void print() {
		int x = top;
		if(!isEmpty()) {
			for(int i = 0; i <= top; i++) {
				System.out.println(stack[x] + " ");
				x -= 1;
			}
		}
	}
	
	public boolean search(String name) {
		if(!isEmpty()) {
			for(int i = 0; i <= top; i++) {
				if(name.equals(stack[i].stuName.toString())) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isEmpty() {
		return (size == -1);
	}
	
	private boolean isFull() {
		return (top == stack.length-1);
	}
	
	public static void main(String[] args) {
		Student e1 = new Student("Adam", 415554, 23);
		Student e2 = new Student("Bob", 432554, 13);
		Student e3 = new Student("Charlie", 485354, 81);
		StackObject stack = new StackObject();
		stack.push(e1);
		stack.push(e2);
		stack.push(e3);
		stack.print();
		stack.peek();
		System.out.println("====");
		stack.pop();
		stack.print();
		System.out.println(stack.search("Job"));
	}
}
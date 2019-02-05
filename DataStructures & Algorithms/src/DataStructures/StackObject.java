package DataStructures;

public class StackObject { //Rework needed to search using name

	private int top;
	private Employee stack[];
	private int size;
	
	private StackObject() {
		top=-1;
		size=1;
		stack=new Employee[size];
	}
	
	private StackObject(int size) {
		top=1;
		this.size=size;
		stack=new Employee[this.size];
	}
	
	private void reSize() {
		if(isFull()) {
			Employee temp[]=stack;
			size*=2;
			stack=new Employee[size];
			for(int i=0;i<=top;i++) {
				stack[i]=temp[i];
			}
		}
	}
	
	public Employee push(Employee item) {
		if(!isFull()) {
			top++;
			stack[top]=item;
		} else {
			reSize();
			top++;
			stack[top]=item;
		}
		return item;
	}
	
	public void pop() {
		if(!isEmpty()) {
			Employee item=stack[top];
			top--;
		} else {
			throw new IllegalStateException("No elements to pop");
		}
	}
	
	public void peek() {
		System.out.println(stack[top]);
	}
	
	public void print() {
		int x=top;
		if(!isEmpty()) {
			for(int i=0;i<=top;i++) {
				System.out.println(stack[x]+" ");
				x-=1;
			}
		}
	}
	
	public boolean search(Employee name) {
		if(!isEmpty()) {
			for(int i=0;i<=top;i++) {
				if(stack[i]==name) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isEmpty() {
		return (size==-1);
	}
	
	private boolean isFull() {
		return (top==stack.length-1);
	}
	
	public static void main(String[] args) {
		Employee e1=new Employee("Adam",415554,23);
		Employee e2=new Employee("Bob",432554,13);
		Employee e3=new Employee("Charlie",485354,81);
		StackObject so=new StackObject();
		so.push(e1);
		so.push(e2);
		so.push(e3);
		so.print();
		so.peek();
		System.out.println("====");
		so.pop();
		so.print();
	}
}
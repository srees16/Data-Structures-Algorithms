package DataStructures;

public class StackInt {
	
	private int stack[];
	private int top;
	private int size;
	
	private StackInt() {
		top=-1;
		size=1;
		stack=new int[size];
	}
	
	private StackInt(int size) {
		top=-1;
		this.size=size;
		stack=new int[this.size];
	}
	
	private void reSize() {
		if(isFull()) {
			int temp[]=stack;
			size*=2;
			stack=new int[size];
			for(int i=0;i<=top;i++) {
				stack[i]=temp[i];
			}
		}
	}

	private boolean isFull() {
		return (top==stack.length-1);
	}
	
	public void peek() {
		System.out.println(stack[top]);
	}
	
	private boolean isEmpty() {
		return (top==-1);
	}
	
	public int push(int item) {
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
	
	public Integer pop() {
		if(!isEmpty()) {
			int item=stack[top];
			top--;
			return item;
		} else {
			throw new IllegalStateException("Can't delete unexisting item");
		}
	}
	
	public void printAll() {
		int f=top;
		if(!isEmpty()) {
			for(int i=0;i<=top;i++) {
				System.out.print(stack[f]+" ");
				f-=1;
			}
		}
	}
	
	public boolean search(int item) {
		if(!isEmpty()) {
			for(int i=0;i<=top;i++) {
				if(stack[i]==item) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		StackInt si=new StackInt(2);
		si.push(56);
		si.push(12);
		si.push(26);
		si.push(85);
		si.printAll();
		System.out.println(si.search(45));
		si.pop();
		si.printAll();
		si.peek();
	}
}
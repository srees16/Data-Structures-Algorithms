package DataStructures;

public class QueueObject { //Rework on the search by name method, whozBack method

	private Employee queue[];
	private int front;
	private int rear;
	private int size;
	
	private QueueObject() {
		front=0;
		rear=0;
		size=1;
		queue=new Employee[size];
	}
	
	private QueueObject(int size) {
		front=0;
		rear=0;
		this.size=size;
		queue=new Employee[this.size];
	}
	
	public Employee enq(Employee item) {
		if(!isFull()) {
			queue[rear]=item;
			rear=(rear+1)%size;
		} else {
			reSize();
			queue[rear]=item;
			rear=(rear+1)%size;
		}
		return item;
	}
	
	public Employee deq() {
		if(!isEmpty()) {
			Employee item=queue[front];
			front=(front+1)%size;
			return item;
		} else {
			throw new IllegalStateException("No items left to delete");
		}
	}
	
	private void reSize() {
		Employee temp[]=queue;
		size*=2;
		queue=new Employee[size];
		for(int i=0;i<=rear;i++) {
			queue[i]=temp[i];
		}
	}
	
	private boolean isEmpty() {
		return front==rear;
	}
	
	private boolean isFull() {
		return size==queue.length;
	}
	
	public void search(String name) {
		int f=front;
		if(f!=-1) {
			for(int i=0;i<rear;i++) {
				System.out.println(queue[f]);
				f+=1;
			}
		}
	}
	
	public void whozBack() {
		System.out.println(queue[rear]);
	}
	
	public void whozFront() {
		System.out.println(queue[front]);
	}
	
	public void print() {
		int f=front;
		if(f!=-1) {
			for(int i=0;i<rear;i++) {
				System.out.println(queue[f]);
				f+=1;
			}
		}
	}
	
	public static void main(String[] args) {
		Employee e1=new Employee("Adam",415554,23);
		Employee e2=new Employee("Bob",432554,13);
		Employee e3=new Employee("Charlie",485354,81);
		Employee e4=new Employee("Don",155354,40);
		QueueObject qo=new QueueObject();
		qo.enq(e1);
		qo.enq(e2);
		qo.enq(e3);qo.enq(e4);
		qo.whozBack();
		qo.print();
		qo.deq();
		System.out.println();
		qo.print();
		System.out.println();
		qo.whozFront();
	}
}
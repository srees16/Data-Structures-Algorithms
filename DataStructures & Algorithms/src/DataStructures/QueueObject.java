package DataStructures;

public class QueueObject {

	private Employee queue[];
	private int front;
	private int rear;
	private int size;
	
	private QueueObject() {
		front = 0;
		rear = 0;
		size = 1;
		queue = new Employee[size];
	}
	
	private QueueObject(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		queue = new Employee[this.size];
	}
	
	public Employee enqueue(Employee employee) {
		if(!isFull()) {
			queue[rear] = employee;
			rear = (rear + 1) % size;
		} else {
			reSize();
			queue[rear] = employee;
			rear = (rear + 1) % size;
		}
		return employee;
	}
	
	public Employee dequeue() {
		if(!isEmpty()) {
			Employee employee = queue[front];
			front = (front + 1) % size;
			return employee;
		} else {
			throw new IllegalStateException("No items left to delete");
		}
	}
	
	private void reSize() {
		Employee tempQueue[] = queue;
		size *= 2;
		queue = new Employee[size];
		for(int i = 0; i <= rear; i++) {
			queue[i] = tempQueue[i];
		}
	}
	
	private boolean isEmpty() {
		return (front == rear);
	}
	
	private boolean isFull() {
		return (size == queue.length);
	}
	
	public boolean search(String name) {
		if(!isEmpty()) {
			for(int i = 0; i < rear; i++) {
				if(name.equalsIgnoreCase(queue[i].empName)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void elementAtRear() {
		System.out.println("Rear of the Queue is " + queue[--rear]);
	}
	
	public void elementAtFront() {
		System.out.println("Front of the Queue is " + queue[front]);
	}
	
	public void print() {
		int f=front;
		if(f!=-1) {
			for(int i=0;i<rear;i++) {
				System.out.println(queue[f]);
				f+=1;
			}
		}
		/*if(!isEmpty()) {
			for(int i = front; i < rear; i++) {
				System.out.println(queue[i]);
			}
		}*/
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Adam",415554,23);
		Employee e2 = new Employee("Bob",432554,13);
		Employee e3 = new Employee("Charlie",485354,81);
		Employee e4 = new Employee("Don",155354,40);
		QueueObject queue = new QueueObject();
		queue.enqueue(e1);
		queue.enqueue(e2);
		queue.enqueue(e3);
		queue.enqueue(e4);
		queue.print();
		System.out.println("========");
		queue.elementAtFront();
		queue.elementAtRear();
		queue.dequeue();
		System.out.println("========");
		queue.print();
		System.out.println();
		queue.elementAtFront();
		System.out.println("========");
		System.out.println(queue.search("don"));
	}
}
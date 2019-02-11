package DataStructures;

public class QueueInt {

	private int size;
	private int front;
	private int rear;
	private int queue[];
	
	public QueueInt() {
		front = 0;
		rear = 0;
		size = 1;
		queue = new int[size];
	}
	
	public QueueInt(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		queue = new int[this.size];
	}
	
	private void reSize() {
		int temp[] = queue;
		size *= 2;
		queue = new int[size];
		for(int i = 0; i <= rear; i++) {
			queue[i] = temp[i];
		}
	}
	
	public int enqueue(int item) {
		if(!isFull()) {
			queue[rear] = item;
			rear = (rear + 1) % size;
		} else {
			reSize();
			queue[rear] = item;
			rear = (rear + 1) % size;
		}
		return item;
	}
	
	public void dequeue() {
		if(!isEmpty()) {
			int item = queue[front];
			front = (front + 1) % size;
		} else {
			throw new IllegalStateException("You cant delete more man!");
		}
	}
	
	public void print() {
		int x = front;
		if(!isEmpty()) {
			for(int i = 0; i < rear; i++) {
				System.out.println(queue[x]);
				x += 1;
			}
		}
	}
	
	public boolean search(int item) {
		if(!isEmpty()) {
			for(int i = 0; i <= rear; i++) {
				if(queue[i] == item) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isFull() {
		return (size == queue.length);
	}
	
	private boolean isEmpty() {
		return (front == rear);
	}
	
	public static void main(String[] args) {
		QueueInt queue = new QueueInt();
		queue.enqueue(41);
		queue.enqueue(15);
		queue.enqueue(52);
		queue.enqueue(72);
		queue.enqueue(48);
		queue.enqueue(62);
		queue.print();
		queue.dequeue();
		System.out.println("====");
		queue.print();
		System.out.println(queue.search(752));
	}
}
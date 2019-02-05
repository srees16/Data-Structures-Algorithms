package DataStructures;

public class QueueInt {

	private int size;
	private int front;
	private int rear;
	private int queue[];
	
	public QueueInt() {
		front=0;
		rear=0;
		size=1;
		queue=new int[size];
	}
	
	public QueueInt(int size) {
		front=0;
		rear=0;
		this.size=size;
		queue=new int[this.size];
	}
	
	private void reSize() {
		int temp[]=queue;
		size*=2;
		queue=new int[size];
		for(int i=0;i<=rear;i++) {
			queue[i]=temp[i];
		}
	}
	
	public int enq(int item) {
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
	
	public void deq() {
		if(!isEmpty()) {
			int item=queue[front];
			front=(front+1)%size;
		} else {
			throw new IllegalStateException("You cant delete more man!");
		}
	}
	
	public void print() {
		int x=front;
		if(!isEmpty()) {
			for(int i=0;i<rear;i++) {
				System.out.println(queue[x]);
				x+=1;
			}
		}
	}
	
	public boolean search(int item) {
		int f=front;
		if(f!=-1) {
			for(int i=0;i<=rear;i++) {
				if(queue[i]==item) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isFull() {
		return size==queue.length;
	}
	
	private boolean isEmpty() {
		return front==rear;
	}
	
	public static void main(String[] args) {
		QueueInt q=new QueueInt();
		q.enq(41);
		q.enq(15);
		q.enq(52);
		q.enq(72);
		q.enq(48);
		q.enq(62);
		q.print();
		q.deq();
		System.out.println();
		q.print();
		System.out.println(q.search(752));
	}
}
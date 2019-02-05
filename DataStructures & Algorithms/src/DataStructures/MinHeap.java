package DataStructures;

import java.util.Arrays;

public class MinHeap {

	private int capacity;
	private int size;
	private int heap[];
	
	public MinHeap() {
		capacity=1;
		size=0;
		heap=new int[size];
	}
	
	private int getLeftChildIndex(int parentIndex) {
		return 2*parentIndex+1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2*parentIndex+2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	private boolean hasLeftChild(int index) {
		return heap[getLeftChildIndex(index)]<0;
	}
	
	private boolean hasRightChild(int index) {
		return heap[getRightChildIndex(index)]<0;
	}
	
	private boolean hasParent(int index) {
		return heap[getParentIndex(index)]>=0;
	}
	
	private int getLeftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}
	
	private int getRightChild(int index) {
		return heap[getRightChildIndex(index)];
	}
	
	private int getParent(int index) {
		return heap[getParentIndex(index)];
	}
	
	private void swap(int indexOne, int indexTwo) {
		int temp=heap[indexOne];
		heap[indexOne]=heap[indexTwo];
		heap[indexTwo]=temp;
	}
	
	private void getXtraCapacity() {
		if(size==capacity) {
			heap=Arrays.copyOf(heap, capacity*2);
			capacity*=2;
		}
	}
	
	public int heapTop() {
		if(size!=0) {
			return heap[0];
		} else {
			throw new IllegalStateException("The heap is empty!");
		}
	}
	
	public int add(int item) {
		getXtraCapacity();
		heap[size]=item;
		size++;
		heapUp();
		return item;
	}
	
	public int delete() {
		if(size==0) {
			throw new IllegalStateException("Cant delete unexisting items");
		} else {
			int item=heap[0];
			heap[0]=heap[size-1];
			size--;
			heapDown();
			return item;
		}
	}

	private void heapUp() {
		int index=size-1;
		while(hasParent(index) && getParent(index)<heap[index]) {
			swap(getParentIndex(index),index);
			index=getParentIndex(index);
		}
	}
	
	private void heapDown() {
		int index=0;
		while(hasLeftChild(index)) {
			int smallerChildIndex=getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index)<getLeftChild(index)) {
				smallerChildIndex=getRightChildIndex(index);
			}
			if(heap[index]<heap[smallerChildIndex]) {
				break;
			} else {
				swap(smallerChildIndex,index);
			}
			index=smallerChildIndex;
		}
	}

	public static void main(String[] args) {
	}
}
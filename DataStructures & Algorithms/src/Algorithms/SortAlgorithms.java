package Algorithms;

import java.util.Arrays;
import java.util.*;

/*Learn the below algorithms first
 * 1. Insertion Sort
 * 2. Selection Sort
 * 3. Bubble Sort
 * 4. Merge Sort
 * 5. Quick Sort
 * 6. Heap Sort
 */

public class SortAlgorithms {
	
	//Insertion Sort
	public static int[] insertionSort(int insList[]) {
		int i,j,temp,key;
		for(i=1;i<insList.length;i++) {
			key=insList[i];
			j=i-1;
			while(j>=0 && key<insList[j]) {
				temp=insList[j];
				insList[j]=insList[j+1];
				insList[j+1]=temp;
				j--;
			}
		}
		return insList;
	}
	
	//Selection Sort
	public static int[] selectionSort(int x[] ) {
		int i,j,minVal,minIndex,temp=0;
		for(i=0;i<x.length;i++) {
			minVal=x[i];
			minIndex=i;
			for(j=i;j<x.length;j++) {
				if(x[j]<minVal) {
					minVal=x[j];
					minIndex=j;
				}
			}
			if(minVal<x[i]) {
				temp=x[i];
				x[i]=x[minIndex];
				x[minIndex]=temp;
			}
		}
		return x;
	}
	
	//Bubble Sort
	public static int[] bubbleSort(int list[]) {
		int i,j,temp=0;
		for(i=0;i<list.length-1;i++) {
			for(j=0;j<list.length-1-i;j++) {
				if(list[j]>list[j+1]) {
					temp=list[j];
					list[j]=list[j+1];
					list[j+1]=temp;
				}
			}
		}
		return list;
	}
	
	//Merge Sort
	void mergesort(int array[]) {
		mergesort(array,new int [array.length],0,array.length-1);
	}
	
	private void mergesort(int[] array, int temp[], int leftstart, int rightend) {
		if(leftstart>=rightend) {
			return;
		}
		int middle=(leftstart+rightend)/2;
		mergesort(array,temp,leftstart,middle);
		mergesort(array,temp,middle+1,rightend);
		mergehalves(array,temp,leftstart,rightend);
	}
	
	private void mergehalves(int[] array, int temp[], int leftstart, int rightend) {
		int leftend=(leftstart+rightend)/2;
		int rightstart=leftend+1;
		int size=rightend-leftstart+1;
		
		int left=leftstart;
		int right=rightstart;
		int index=leftstart;
		
		while(left<=leftend && right<=rightend) {
			if(array[left]<=array[right]) {
				temp[index]=array[left];
				left++;
			} else {
				temp[index]=array[right];
				right++;
			}
			index++;
		}
		System.arraycopy(array, left, temp, index, leftend-left+1);
		System.arraycopy(array, right, temp, index, rightend-right+1);
		System.arraycopy(temp,leftstart,array,leftstart, size);
	}
	
	//Quick Sort. Ref: https://www.geeksforgeeks.org/quick-sort
	private int partition(int arr[],int low,int high) {
		int pivot=arr[high]; //highest element of the array as pivot
		int i=(low-1); //index of smaller element
		for(int j=low;j<high;j++) {
			if(arr[j]<=pivot) {
				i++;
				int temp=arr[i]; //swap arr[i]<arr[j]
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	
	private void quickSort(int arr[],int low,int high) {
		if(low<high) {
			int partIndex=partition(arr,low,high);
			quickSort(arr,low,partIndex-1);
			quickSort(arr,partIndex+1,high);
		}
	}
	
	private void printQuickSort(int arr[]) {
		int n=arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//Heap Sort. Ref: https://www.geeksforgeeks.org/heap-sort
	private void heapSort(int arr[]) {
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--) {
			heapify(arr,n,i);
		}
		for(int i=n-1;i>=0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,n,0);
		}
	}

	private void heapify(int[] arr,int n,int i) {
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n &&arr[l]>arr[largest]) {
			largest=l;
		}
		if(r<n &&arr[r]>arr[largest]) {
			largest=r;
		}
		if(largest!=i) {
			int swap=arr[i];
			arr[i]=arr[largest];
			arr[largest]=swap;
			heapify(arr,n,largest);
		}
	}
	
	private void printHeapSort(int arr[]) {
		for(int i=0;i<arr.length;++i) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		//Insertion sort
		int list[]={5,8,2,7,6,1};
		insertionSort(list);
		for(int n:list) {
			System.out.println(n+" ");	
		}
		//System.out.println(selectionSort(list));
		//System.out.println(bubbleSort(list));
	}
}
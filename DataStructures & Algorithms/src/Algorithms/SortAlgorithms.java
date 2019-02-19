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

@SuppressWarnings("unused")
public class SortAlgorithms {
	
	//Insertion Sort
	private static String insertionSort() {
		int array[] = {3,6,8,9,2,1,7,4};
		int temp;
		for(int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while(j >= 0 && key < array[j]) {
				temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
				j--;
			}
		}
		return Arrays.toString(array);
	}
	
	//Selection Sort
	public static String selectionSort() {
		int array[] = {3,6,8,9,2,1,7,4};
		int i , j, minVal, minIndex, temp=0;
		for(i = 0; i < array.length; i++) {
			minVal = array[i];
			minIndex = i;
			for(j = i; j < array.length; j++) {
				if(array[j] < minVal) {
					minVal = array[j];
					minIndex = j;
				}
			}
			if(minVal < array[i]) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
		return Arrays.toString(array);
	}
	
	//Bubble Sort
	public static String bubbleSort() {
		int array[] = {3,6,8,9,2,1,7,4};
		int i, j, temp = 0;
		for(i = 0; i < array.length-1; i++) {
			for(j = 0; j < array.length - 1 - i; j++) {
				if(array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return Arrays.toString(array);
	}
	
	//Merge Sort
	static void mergesort() {
		int array[] = {3,6,8,9,2,1,7,4};
		mergesort(array, new int [array.length], 0 , array.length - 1);
	}
	
	private static void mergesort(int[] array, int temp[], int leftstart, int rightend) {
		if(leftstart >= rightend) {
			return;
		}
		int middle = (leftstart + rightend) / 2;
		mergesort(array, temp, leftstart, middle);
		mergesort(array, temp, middle + 1, rightend);
		mergehalves(array, temp, leftstart, rightend);
	}
	
	private static void mergehalves(int[] array, int temp[], int leftstart, int rightend) {
		int leftend = (leftstart + rightend) / 2;
		int rightstart = leftend + 1;
		int size = rightend - leftstart + 1;
		
		int left = leftstart;
		int right = rightstart;
		int index = leftstart;
		
		while(left <= leftend && right <= rightend) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index]=array[right];
				right++;
			}
			index++;
		}
		System.arraycopy(array, left, temp, index, leftend - left + 1);
		System.arraycopy(array, right, temp, index, rightend - right + 1);
		System.arraycopy(temp, leftstart, array, leftstart, size);
	}
	
	//Quick Sort. Ref: https://www.geeksforgeeks.org/quick-sort
	private int partition(int array[], int low, int high) {
		int pivot = array[high]; //highest element of the array as pivot
		int i = (low - 1); //index of smaller element
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i++;
				int temp = array[i]; //swap arr[i]<arr[j]
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}
	
	private void quickSort(int array[], int low, int high) {
		if(low < high) {
			int partIndex = partition(array, low, high);
			quickSort(array, low, partIndex - 1);
			quickSort(array, partIndex + 1, high);
		}
	}
	
	private void printQuickSort(int array[]) {
		int n = array.length;
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	//Heap Sort. Ref: https://www.geeksforgeeks.org/heap-sort
	private static void heapSort() {
		int array[] = {3,6,8,9,2,1,7,4};
		int n = array.length;
		for(int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i);
		}
		for(int i = n - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapify(array, n, 0);
		}
	}

	private static void heapify(int[] array, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if(l < n && array[l] > array[largest]) {
			largest = l;
		}
		if(r < n && array[r] > array[largest]) {
			largest = r;
		}
		if(largest != i) {
			int swap = array[i];
			array[i] = array[largest];
			array[largest] = swap;
			heapify(array, n, largest);
		}
	}
	
	private static void printHeapSort() {
		int array[] = {3,6,8,9,2,1,7,4};
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		System.out.println(insertionSort());
		System.out.println(selectionSort());
		System.out.println(bubbleSort());
		//mergesort();
		//heapSort();
		//printHeapSort();
	}
}
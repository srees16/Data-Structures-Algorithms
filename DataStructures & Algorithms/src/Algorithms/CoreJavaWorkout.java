package Algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import org.junit.Test;

/*
Exercises referenced from:
https://beginnersbook.com/2017/09/java-examples
https://www.w3resource.com/java-exercises/array/index.php
http://code-exercises.com
https://projecteuler.net/archives

Also refer for algorithms and other resourceful Java tutorials: https://github.com/eugenp/tutorials

To Do:
>	reverse an array
>	reverse a string
>	return an array of nos whose sum is the input no
>	max difference between 2 nos in array
>	Write a program which takes 2 digits,X,Y as input and generates a 2-dimensional array. The element value in the i-th row and j-th column of the array should be i*j.
Example the inputs are given to the program: 3,5
The output of the program should be:
[[0, 0, 0, 0, 0], [0, 1, 2, 3, 4], [0, 2, 4, 6, 8]]
> Ans
row_num=int(input('Enter X: '))
col_num=int(input('Enter Y: '))
multiple_list=[[0 for col in range(col_num)] for row in range(row_num)]
for row in range(row_num):
    for col in range(col_num):
        multiple_list[row][col]=row*col
print(multiple_list)

>	Write a function that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
Given A = [1, 2, 3], the function should return 4.
Given A = [-1,-3], the function should return 1.
Ex:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [-1,000,000..1,000,000]

> Print all possible combinations of r elements in a given array of size n. Ref:https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n

*/

@SuppressWarnings("unused")
public class CoreJavaWorkout {

	//Find Sum of Natural Numbers
	private static int sumOfNaturalNos(int numTill) {
		int a = 0;
		for(int i = 1; i <= numTill; i++) {
			a = a + i;
		}
		return a;
	}

	//Sum of multiples of 3 and 5
	static void oddMultiples(int x) {
		int f = 0;
		for(int i = 1; i < x; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				f += i;//f=f+i
				//System.out.println(i);
			}
		}
		System.out.println("Multiples of odd numbers is " + f);
	}

	//Check if a number is Positive or Negative
	private static void positiveOrNegative(int number) {
		if(number <= 0) {
			System.out.println("Negative no!");
		} else {
			System.out.println("Positive no!");
		}
	}

	//Check Even or Odd Number
	private static int checkEvenOrOdd(int num) {
		if (num % 2 == 0) {
			System.out.println("Even No");
		} else {
			System.out.println("Odd No");
		}
		return num;
	}

	//Find the number of even and odd integers in a given array of integers
	private static void countEvenOdds() {
		int x[] = {98, 10, 13, 66, 26, 78, 11, 99};
		int countEven = 0;
		int countOdd = 0;
		for(int i = 0; i < x.length; i++) {
			if(x[i] % 2 == 0) {
				countEven++;
			} else {
				countOdd++;
			}
		}
		System.out.println("No of even nos " + countEven + " and odd nos " + countOdd);
	}
	
	//Find the number of even and odd integers in a given array of integers, and what are they?
		public static void evenOddCount() {
			int evenCount = 0;
			int oddCount = 0;
			int array[] = {54, 74, 23, 89, 12, 53, 76};
			int evenArray[] = {};
			int oddArray[] = {};
			
			System.out.println("Even numbers are: ");
			for(int i = 0; i < array.length; i++) {
				if(array[i] % 2 == 0) {
					System.out.print(array[i] + " ");
					evenCount++;
				}
			}
			System.out.println();
			System.out.println("Odd numbers are: ");
			for(int i = 0; i < array.length; i++) {
				if(array[i] % 2 != 0) {
					System.out.print(array[i] + " ");
					oddCount++;
				}
			}
			System.out.println();
			System.out.println("No of even integers are " + evenCount + " and the no of odd integers in the array are " + oddCount);
			
		}
	
	//Display prime numbers between 1 and 100 or 1 and n
	private static void first100PrimeNos(int primesUpto) { //Needs improvement
		System.out.print(2 + ", " + 3 + ", " + 5);
		for (int i = 5; i < primesUpto; i++) {
			if (i % 2 != 0 && i % 3 != 0 && i % 5 !=0) {
				System.out.print(", " + i);
			}
		} 
	}
	
	//Summation of primes below given number
	private static void summationOfPrimes(int inputNumber) {
		int sum = 10; //since the sum of 2  + 3 + 5 which are primes
		for(int i = 2; i < inputNumber; i++) {
			if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
				sum += i;
			}
		}
		System.out.println("Sum of all primes until the input number is " + sum);
	}

	//Sum of elements of an array
	private static void sumOfArray() {
		int array[] = {5, 2, 8, 6, 3};
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count = count + array[i];
		}
		System.out.println(count);
	}
		
	//Calculate average of numbers of an Array
	private static double averageOfArray(double numArray[]) {
		double total = 0;
		for (int i = 0; i < numArray.length; i++) {
			total = total + numArray[i];
		}
		double average = total/numArray.length;
		return average;
	}
	
	//Find all the non repeating elements or duplicate nos in array
	private static void findAllNonRepeat(int Array[]) { //https://www.geeksforgeeks.org/non-repeating-element/
		for(int i = 0; i < Array.length; i++) {
			int j;
			for(j = 0; j < Array.length; j++) {
				if(i != j && Array[i] == Array[j]) {
					break;
				}
			}
			if(j == Array.length) {
				System.out.print(Array[i] + " ");
			}
		}
		//return -1;
	}
	
	//Find all the repeating elements or duplicate nos in array
	private static void findAllRepeat(int Array[]) {
		for(int i = 0; i < Array.length; i++) {
			int j;
			for(j = 0; j < Array.length; j++) {
				if(i != j && Array[i] == Array[j]) {
					break;
				}
			}
			if(j != Array.length) {
				System.out.print(Array[i] + " ");
			}
		}
	}
	
	private static int[] findAllNonRepeats() { //https://www.sanfoundry.com/java-program-find-number-non-repeated-elements-array
		int flag = 0, count = 0;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter how many elements in array");
		int n = s.nextInt();
		int A[] = new int[n];
		System.out.println("Enter the elements");
		for(int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.println("Non repeated elements are:");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(A[i] != A[j]) {
						flag = 1;
					} else {
						flag = 0;
						break;
					}
				}
			}
			if(flag == 1) {
				count++;
				System.out.println(A[i] + " ");
			}
		}
		s.close();
		System.out.println("No of non repeat elements " + count);
		return A;
	}
	
	//Find duplicate/repeat of each character in a string and count their occurrences
	private static void duplicateCharacterCount() {
		String word = "appreciation";
		Map<Character, Integer> charactersMap = new HashMap<>();
		char characters[] = word.toCharArray();
		for(char ch : characters) {
			if(charactersMap.containsKey(ch)) {
				charactersMap.put(ch, charactersMap.get(ch) + 1);
			} else {
				charactersMap.put(ch, 1);
			}
			
		}
		Set<Character> keys = charactersMap.keySet();
		for(char ch : keys) {
			if(charactersMap.get(ch) > 1) {
				System.out.println(ch + " repeated " + charactersMap.get(ch) + " times");
			} else {
				System.out.println(ch + " repeated " + charactersMap.get(ch) + " times");
			}
		}
	}

	//Find the element that is repeated a majority no of times from an given array of integers containing duplicates
	private static void majorityDuplicateElement() {
		int x[] = {98,10,13,66,10,78,11,99,98,11,13,99,98,10,63};
		int countDuplicate = 0;
		for(int i = 0; i < x.length-1; i++) {
			for(int j = i+1; j < x.length-1; j++) {
				if(x[i] == x[j]) {
					countDuplicate++;
				}
			}
		}
		System.out.println();
	}
	
	
	//Find the duplicate values of an array of integer values
	private static boolean duplicateElements() {
		int myArray[] = {98,10,13,66,26,78,11,99}; 
		for(int i = 0; i < myArray.length; i++) {
			for(int j = i+1; j < myArray.length; j++) {
				if(myArray[i] == myArray[j]) {
					return true;
				}
			}
		}
		return false;
	}

	//Find common elements between two arrays (integers)
	private static void commonIntegerElements() {
		int x[] = {98,10,13,66,26,78,11,99};
		int y[] = {43,78,22,99,22};
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < y.length; j++) {
				if(x[i] == y[j]) {
					System.out.println(x[i]);
				}
			}
		}
	}

	/*Remove duplicate elements from an array and return the new length of the array.
	After removing the duplicate elements the program should return new length of the array*/
	private static void removeDuplicates() {
		boolean isDuplicate = false;
		int A[] = {20, 20, 30, 40, 50, 50};
		for(int i = 0; i < A.length-1; i++) {
			for(int j = i+1; j < A.length-1; ++j) {
				if(A[i] == A[j]) {
					isDuplicate = true;
				}
			}
			if(isDuplicate) {
				A[i] = A[i + 1];
				arrayResize(A);
			}
		}
		System.out.println(Arrays.toString(A));
	}
	
	/*https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x*/
	private static void pairOfInput(int a[],int no) {
		HashSet<Integer> hset = new HashSet<>();
		Arrays.sort(a);
		System.out.println("Pair of given no " + no + " is ");
		for(int i = 0; i < a.length-1; i++) {
			int temp = no - a[i];
			if(temp >= 0 && hset.contains(temp)) {
				System.out.println(temp + ", " + a[i]);
			}
			hset.add(a[i]);
		}
	}
	
	private static void arrayOfInput(int a[],int no,int arrayLength) {
		HashSet<Integer> hset = new HashSet<>();
		Arrays.sort(a);
		System.out.println("Pair of given no " + no + " is ");
		for(int i = 0; i < a.length-1; i++) {
			int temp = no - a[i];
			if(temp >= 0 && hset.contains(temp)) {
				System.out.println(a[i] + ", " + temp);
			}
			hset.add(a[i]);
		}
	}

	//Find if an array contains a specific value
	private static boolean findElement(int element) {
		int array[] = {5,2,8,6,};
		boolean isFound = false;
		for(int i = 0; i < array.length ; i++) {
			if(element == array[i]) {
				isFound = true;
			} else {
				isFound = false;
			}
			if(isFound == true) {
				System.out.println("Element " + element + " found");
			}
		}
		return false;
	}

	//Find the index of an array element
	private static int findIndexOfElement(int element) { //Bug: Removed element's index replaced by its next element
		int elements[] = {34,6,43,325,62};
		for(int i = 0; i < elements.length; i++) {
			if(element == elements[i]) {
				return i;
			}
		}
		return 0;
	}

	//Remove a specific element from an array using index no
	private static void removeElement(int element) {
		int elements[] = {34,6,43,325,62};
		int removeElement = element;
		System.out.println(Arrays.toString(elements));
		for(int i = removeElement; i < elements.length-1; i++) {
			elements[i] = elements[i + 1];
		}
		System.out.println(Arrays.toString(elements));
	}

	//Reverse a number using for, while loop and recursion. For 12345, output should be 54321
	private static void numReverseWhile(int number) {
		int n = 654;  //Prefer this bcoz its more intuitive
		while (n > 0) {
			int digit = n % 10;
			System.out.print(digit);
			n = n/10; 
			digit = n;
		}
		/*int x=785; //less intuitive approach
		while (x>0) {
			int d = x/10;
			int k = x%10; 
			x=d;
			System.out.print(k);
		}*/
	}
	
	private static void numReverseFor(int num) {
		for(int i = 0; i < num; i++) {
			
		}
	}

	private static void numReverseRecursion(int num) {
		
	}

	//Reverse an array
	private static void reverseArray(/*int array[]*/) {
		int array[] = {5,2,8,6,};
		for(int i = array.length-1; i < 0; i--) {
			System.out.print(array[i]);
		}
	}

	private static void reverseArrayStack() {
		int array[] = {5,2,8,6,};
		Stack<Integer> stack = new Stack<>();
		
	}


	//Reverse a String using Recursion
	public static String reverseString(String word) {
		if (word.length() <= 1) {
			return word;
		} else {
			return reverseString(word.substring(1)) + word.charAt(0);
		}
	}
	
	//Reverse the words along with the letters in a sentence
	private static void sentenceReverse(String sentence) {
		String words[] = sentence.split(" ");
		String reverseSentence = "";
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			String reverseWords = "";
			for(int j = word.length()-1; j >= 0; j--) {
				reverseWords = reverseWords + word.charAt(j);
			}
			reverseSentence = reverseSentence + reverseWords + " ";
		}
 		System.out.println(reverseSentence);
	}

	/*Check if a string is palindrome using recursion, Stack, Queue, for and while loop*/

	//Using Recursion
	private static boolean checkPalindrome(String word) { //Correct for case insensitive
		boolean isPalindrome = false;
		if(word.length() == 0 || word.length() == 1) {
			return true;
		}
		if (word.charAt(0) == word.charAt(word.length()-1)) {
			return checkPalindrome(word.substring(1, word.length()-1));
		}
		return false;
	}
	
	//Using string builder class
	public static boolean checkPalindromes(String word) {
		return word.equals(new StringBuilder(word).reverse().toString());
	}

	//Using Stack
	private static void checkPalindromeStack(String word) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}
		String reverseWord = "";
		while(!stack.isEmpty()) {
			reverseWord = reverseWord + stack.pop();
		}
		if(word.equalsIgnoreCase(reverseWord)) {
			System.out.println("The word '" + word + "' is a palindrome!");
		} else {
			System.out.println("The word '" + word + "' is NOT a palindrome!");
		}
	}

	//Using Queue
	private static void checkPalindromeQueue(String word) {
		Queue<Character> queue = new LinkedList<>(); //
		for(int i = word.length()-1; i >= 0; i--) {
			queue.add(word.charAt(i));
		}
		String reverseWord = "";
		while(!queue.isEmpty()) {
			reverseWord = reverseWord + queue.remove();
		}
		if(word.equalsIgnoreCase(reverseWord)) {
			System.out.println("The word '" + word + "' is a palindrome!");
		} else {
			System.out.println("The word '" + word + "' is NOT a palindrome!");
		}
	}

	//Using For loop
	private static void checkPalindromeFor(String word) {
		String reverseWord = "";
		for(int i = word.length()-1; i >= 0; i--) {
			reverseWord = reverseWord + word.charAt(i);
		}
		if(word.equalsIgnoreCase(reverseWord)) {
			System.out.println("The word '" + word + "' is a palindrome!");
		} else {
			System.out.println("The word '" + word + "' is NOT a palindrome!");
		}
	}

	//Using While loop
	private static void checkPalindromeWhile(String word) {
		String reverseWord = "";
		int i = word.length()-1;
		while(i >= 0) {
			reverseWord = reverseWord + word.charAt(i);
			i--;
		}
		if(word.equalsIgnoreCase(reverseWord)) {
			System.out.println("The word '" + word + "' is a palindrome!");
		} else {
			System.out.println("The word '" + word + "' is NOT a palindrome!");
		}
	}

	//Factorial of a number using recursion
	private static int factorialOf(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorialOf(n-1);
	}

	//Find Largest of three numbers
	private static void findLargest(int x, int y, int z) {
		if(x > y && x > z) {
			System.out.println(x + " is the biggest");
		} else if(y > x && y > z) {
			System.out.println(y + " is the biggest");
		} else {
			System.out.println(z + " is the biggest");
		}
	}

	//Find Smallest of three numbers
	private static void findSmallest(int x, int y, int z) {
		if(x < y && x < z) {
			System.out.println(x + " is the smallest");
		} else if(y < x && y < z) {
			System.out.println(y + " is the smallest");
		} else {
			System.out.println(z + " is the smallest");
		}
	}

	//Find max no in array
	private static void maxNo(int a[]) {
		int temp, i;
		for(i = 0; i < a.length-1; i++) {
			temp = i;
			if(temp < i) {
				i++;
			}
		}
		System.out.println("Max no of the array is " + a[i]);
	}
	
	//Find the largest distance between two neighboring numbers in an array
	private static void largestDistanceOfArrayNeighbours() { //Bug if there is larger no at the end of index
		int array[] = {43,33,96,21,85,34,16,1,62};
		int largestDistance = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] - array[j] > largestDistance) {
					largestDistance = array[i] - array[j];
				}
			}
		}
		System.out.print("Largest distance is ");
		convertNegativeToPositive(largestDistance);
	}
	
	private static void convertNegativeToPositive(int negativeNo) {
		int marker = -1;
		if(negativeNo < 0 )
			negativeNo = negativeNo * marker;
		System.out.println(negativeNo);
	}
	
	//Find the smallest distance between two neighboring numbers in an array
	private static void smallestDistanceOfArrayNeighbours() { //Bug if there is smaller no at the end of index
		int array[] = {43,33,96,21,85,34,16,1};
		int smallestDistance = 0;
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] - array[i] < smallestDistance) {
					smallestDistance = array[i] - array[j];
				}
			}
		}
		System.out.print("Smallest distance is ");
		convertNegativeToPositive(smallestDistance);
	}
	
	//Find the largest and smallest elements of an array
	private static void findMinMaxElements() {
		int myArray[] = {98,26,288,78,11,99,500,6};
		int difference;
		//Using Java 8 Streams
		int max = Arrays.stream(myArray).max().getAsInt();
		int min = Arrays.stream(myArray).min().getAsInt();
		//Using iteration/For loop
		int mini = myArray[0];
		int maxi = myArray[0];
		for(int i = 1; i < myArray.length; i++) {
			if(mini > myArray[i]) {
				mini = myArray[i];
			}
			if(maxi < myArray[i]) {
				maxi = myArray[i];
			}
		}
	 	System.out.println("Min is " + min + " max is " + max);
		difference = max - min;
		System.out.println("Difference of largest & smallest in the array " + Arrays.toString(myArray) + " is " + difference);
	}

	//Compute the average value of an array of integers except the largest and smallest values
	private static void avgOfArray() {
		int myArray[] = {98,26,288,78,11,99,500,6};
		int max = myArray[0];
		int min = myArray[0];
		int avg = 0;
		int sum = 0;
		for(int i = 1; i < myArray.length; i++) {
			if(max < myArray[i]) {
				max = myArray[i];
			}
			if(min > myArray[i]) {
				min = myArray[i];
			}
		}
	}

	//Find the second largest element in an array
	private static void secondLargest() {
		int myArray[] = {98,13,66,26,28,78,11,99};
		int max = myArray[0];
		int secondMax = myArray[0];
		for(int i = 1; i < myArray.length; i++) {
			if(max < myArray[i]) {
				secondMax = max;
				max = myArray[i];
			} else if(myArray[i] > secondMax) {
				secondMax = myArray[i];
			}
		}
		System.out.println(secondMax);
	}

	//Find the second smallest element in an array
	private static void secondSmallest() {
		int array[] = {23,54,85,37,16,97};
		
	}

	private static void secondSmallest2 () {
		int myArray[] = {98,13,66,26,28,78,11,99};
		for(int i = 0; i < myArray.length; i++){
			int elm = myArray[i];
			for(int j = 0;j < myArray.length; j++){
				if(elm > myArray[j]){
					int a = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = a;
				}
			}
		}
		System.out.println("Max is " + myArray[myArray.length-2] + " min is " + myArray[0]);
	}

	//Find the first, second and third largest numbers of the array
	private static void findTopThreeLargest() {
		int array[] = {43,33,96,21,85,34,16};
		int firstLargest = array[0];
		int secondLargest = array[0];
		int thirdLargest = array[0];
		for(int i = 1; i < array.length; i++) {
			if(firstLargest < array[i]) {
				thirdLargest = secondLargest;
				secondLargest = firstLargest;
				firstLargest = array[i];
			} else if(secondLargest < array[i]) {
				thirdLargest = secondLargest;
				secondLargest = array[i];
			} else if(thirdLargest < array[i]) {
				thirdLargest = array[i];
			}
		}
		System.out.println("First largest is " + firstLargest);
		System.out.println("Second largest is " + secondLargest);
		System.out.println("Third largest is " + thirdLargest);
	}

	//Find the first, second and third largest numbers of the array
	private static void findTopThreeSmallest() {
		
	}
	
	//Smallest missing positive no. Ref: https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array-set-2
	private static int smallestMissingInteger(int a[]) {
		int v1, v2;
		for(int i = 0; i < a.length; i++) {
			if(a[i] <= 0 || a[i] > a.length) {
				continue;
			} else {
				v1 = a[i];
				while(a[v1-1] != v1) {
					v2 = a[v1-1];
					a[v1-1] = v1;
					v1 = v2;
					if(v1 <= 0 || v1 > a.length) {
						break;
					}
				}
			}
		}
		for(int i = 0; i < a.length; i++) {
			if(a[i] != i + 1) {
				return i + 1;
			}
		}
		return a.length + 1;
	}
	
	private static int arrayResize(int A[]) {
		int array[] = {20, 20, 30, 40, 50, 50};
		int index = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] != array[index - 1]) {
				array[index++] = array[i];
			}
		}
		return index;
	}
	
	//Convert a char array to a string
	private static void charArrayToString(char chars[]) {
		/*Method using String class*/
		String myString = new String(chars);
		System.out.println(myString);
		/*Method using valueOf function*/
		String myString2 = String.valueOf(chars);
		System.out.println(myString2);
	}
	
	//Find the common elements between two arrays (string values)
	private static void commonStringElements() {
		String x[] = {"Hi", "Hello", "Bye"};
		String y[] = {"Hi", "Heya", "Byee"};
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < y.length; j++) {
				if(x[i] == y[j]) {
					System.out.println(x[i]);
				}
			}
		}
	}

	//Check if two sentences are anagrams: method 1
	private static void isAnagram1() {
		String s1 = "Desperation"; //School MASTER, The ClassROOM; Debit Card, Bad Credit; SiLeNt CAT, LisTen AcT; Mother In Law, Hitler Woman; ASTRONOMERS, NO MORE STARS; Desperation, A Rope Ends It;
		String s2 = "A Rope Ends It";
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		boolean status = true;
		if(s1.length() != s2.length()) {
			status = false;
		} else {
			char c1[] = s1.toLowerCase().toCharArray();
			char c2[] = s2.toLowerCase().toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			status = Arrays.equals(c1, c2);
		}
		if(status) {
			System.out.println(s1 + " and " + s2 + " are anagrams!");
		} else {
			System.out.println(s1 + " and " + s2 + " are NOT anagrams!");
		}
	}
	
	//Check if two sentences are anagrams: method 2
	private static boolean isAnagram2() {
		String s1 = "Mother In Law"; //Listen - Silent; Triangle - Integral
		String s2 = "Hitler Woman";
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		if(s1.length() != s2.length()) {
			return false;
		} else {
			s1 = sortCharacters(s1);
			s2 = sortCharacters(s2);
		}
		return s1.equals(s2);
	}
	
	private static String sortCharacters(String phrase) {
		char [] charArray = phrase.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}

	//Check if two sentences are anagrams: method 2. Ref: https://javaconceptoftheday.com/anagram-program-in-java
	private static void isAnagram3() {
			
	}
	/*
	Find the length of the longest consecutive elements sequence from an unsorted array of integers.
	Ex: [49, 1, 3, 200, 2, 4, 70, 5]
	The longest consecutive elements sequence is [1, 2, 3, 4, 5], so it returns length as 5
	*/
	private static void longestIntegerSequence() {
		int array[] = {49, 1, 3, 200, 2, 4, 70, 5};
		Set<Integer> mySet = new HashSet<>();
		for(int i : array)
			mySet.add(i);
		int longestSequenceLength = 0;
		for(int i : array) {
			int length = 1;
		}
	}
	
	//Find the longest common sub-sequence of two strings
	private static String longestSubStringSequence() {
		String s1 = "full"; String s2 = "powerfully";
		String longestSubSequence = "";
		for(int length = s1.length(); length > 0; length--) {
			int startIndex = 0;
			while(startIndex + length <= s1.length()) {
				String current = s1.substring(startIndex, startIndex + length);
				if(s2.contains(current)) {
					longestSubSequence = current;
					break;
				}
				startIndex++;
			}
			if(longestSubSequence.length() != 0) {
				break;
			}
		}
		return longestSubSequence;
	}
	
	//Average value of elements in list
	private static double average(List<Integer> list) {
		return list.stream()
				.mapToInt(i -> i)
				.average()
				.getAsDouble();
	}

	private static void twoDimArray(int x, int y) {
		for(int i = 0; i < x; i++) {
			int a[] = new int[i];
			for(int j = 0; j < y; j++) {
				//a[i]=new int[j];
			}
		}
	}	

	//Linear Search to search an element in given list of elements
	private static void linearSearch(int findNumber) { //Rework to throw exception for items absent in the list
		int numArray[] = {35, 14, 57, 19, 86, 46, 62};
		for(int i = 0; i < numArray.length; i++) {
			if(numArray[i] == findNumber) {
				System.out.println(findNumber + " is present at location " + (i + 1));
			}
		}
	}	

	//Binary Search to search an element in given list of elements
	private static void binarySearch(int findNumber) { //Doesn't work for few indices. Ref: https://beginnersbook.com/2014/04/java-program-to-perform-binary-search
		int numArray[] = {35, 14, 57, 19, 86, 46, 62};
		int first = 0;
		int last = numArray.length-1;
		int middle = (first + last)/2;
	 
		while(first <= last) {
			if(numArray[middle] < findNumber) {
				first = middle + 1;
			} else if(numArray[middle] == findNumber) {
				System.out.println(findNumber + " is located at " + (middle + 1));
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last)/2;
		}
		if(first > last) {
			System.out.println(findNumber + " item not found");
		}
	}
	
	//Check if leap year. If the year is evenly divisible by 4 and 100 and 400, then it is a leap year */ 
	private static void isLeapYear(int year) {
		boolean isLeap=false;
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0)
					isLeap = true;
				else
					isLeap = false;
			} else {
				isLeap = true;
			}
		} else {
			isLeap = false;
		}
		if (isLeap == true) {
			System.out.println("Its a leap year!");
		} else {
			System.out.println("Its not a leap year!");
		}
	}

	//Find ASCII code of a character
	private static void findAsciiOfCharacter(char ch) {
		char c = ch;
		int asciiCode = c;
		int asciiValue = (int)c;
		System.out.println("ASCII code is " + asciiCode + " and ASCII value is " + asciiValue);
	}

	/*//Get local IP address
	private static void getIP() {
	 	try {
	  		InetAddress myIp = InetAddress.getLocalHost();
	 	} catch (UnknownHostException e) {
	  		e.printStackTrace();
	 	}
	 System.out.println("IP Address is " + myIp.getHostAddress());
	}*/
	
	/*Fibonacci Series using For & While loops*/

	//Using For loop
	private static void fibonacciFor(int number) { //0, 1, 1, 2, 3, 5, 8, 13
		int firstNo = 0;
		int secondNo = 1;
		int thirdNo;
		System.out.print(0 + ", " + 1);
		for(int i = 0; i < number; i++) {
			thirdNo = firstNo + secondNo;
			System.out.print(", " + thirdNo);
			firstNo = secondNo;
			secondNo = thirdNo;
		}
		//Smart way!
		/*int index=0;
		int next=1;
		int incr=0;
		System.out.print(index+","+next);			
		for(int i=index;i<10;++i) {
			incr=index+next;
		System.out.print(","+incr);
		index=next;
		next=incr;
		}*/
		
		//Even Fibonacci numbers
		/*int index=0;
		int next=1;
		int incr=0;			
		System.out.print(index+","+next);
		for(int i=index;i<15;++i) {
			if(i%2==0) {
			System.out.print(i+",");
			incr=index+next;
			index=next;
			next=incr;
			}
		}*/
	}

	//Using While loop
	private static void fibonacciWhile(int number) { //0, 1, 1, 2, 3, 5, 8, 13  //Got bugs, rework needed
		int firstNo = 0;
		int secondNo = 1;
		int thirdNo = 0;
		System.out.print(0 + ", " + 1);
		while(thirdNo < number) {
			thirdNo = firstNo + secondNo;
			System.out.print(", " + thirdNo);
			firstNo = secondNo;
			secondNo = thirdNo;
		}
	}

	/*Tribonacci Series using For & While loops*/

	//Using For loop
	private static void tribonacciFor(int number) { //0, 1, 1, 2, 4, 7, 13, 24
		int firstNo = 0;
		int secondNo = 0;
		int thirdNo = 1;
		int fourthNo;
		System.out.print(0 + ", " + 1 + ", " + 1 + ", ");
		for(int i = 0; i < number; i++) {
			fourthNo = firstNo + secondNo + thirdNo;
			System.out.print(fourthNo + ", ");
			firstNo = secondNo;
			secondNo = thirdNo;
			thirdNo = fourthNo;
		}
	}

	//Using While loop
	private static void tribonacciWhile(int number) { //0, 1, 1, 2, 4, 7, 13, 24 //Got bugs, rework needed
		int firstNo = 0;
		int secondNo = 0;
		int thirdNo = 1;
		int fourthNo = 0;
		System.out.print(0 + ", " + 1 + ", ");
		while(fourthNo < number) {
			fourthNo = firstNo + secondNo + thirdNo;
			System.out.print(fourthNo + ", ");
			firstNo = secondNo;
			secondNo = thirdNo;
			thirdNo = fourthNo;
		}
	}
	
	//Check Armstrong number for 3 digits. Ref: https://www.guru99.com/java-program-check-armstrong-number.html
	private static void checkArmstrongNo(int number) { //An Armstrong number is an integer if the sum of the cubes of its digits is equal to the number itself. Ex: 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371
		int digit, digitCubeSum = 0, tempNumber;
		tempNumber = number;
		while(tempNumber!=0) {
			digit = tempNumber % 10;
			digitCubeSum = digitCubeSum + (digit * digit * digit);
			tempNumber /= 10;
		}
		if(number == digitCubeSum) {
			System.out.println(number + " is an Armstrong number");
		} else {
			System.out.println(number + " is NOT an Armstrong number");
		}
	}

	//Find GCD of two numbers
	private static void gcdOfNumbers() {
		int x = 25; int y = 50;
		for(int i = 1; i <= 10; i++) {
			if(x % i == 0) {
				System.out.print(i + ", ");
			}
		}
	}
	
	//Multiples of a number
	private static void multiplesOfNumber() {
		int x = 30;
		//2*2*3*3
		
	}

	//Copy an array by iterating the array
	private static void copyArrayTo() { //Rework needed to check how copy works if the destination array has no elements
		int x[] = {3,64,67,22,56};
		int y[] = {85,71,67,32,75};
		for(int index = 0; index < x.length-1; index++) {
			y[index] = x[index];
		}
		System.out.println(Arrays.toString(y));
	}

	//Copy an array by iterating the array
	private static void copyArrayTo2() {
		int x[] = {3,64,67,22,56};
		int count = 0;
		int y[] = {85,71,67,32,75,5};
		int k[] = new int[x.length + y.length];
		for(int index = 0; index < (x.length + y.length); index++) {
			if(index < x.length)
				k[index] = x[index];
			else{
				k[index] = y[count];
				count += 1;
			}
		}
		System.out.println(Arrays.toString(k));
	}
	 
	//Insert an element in a specific position into an array
	private static void insertElement(int element, int index) {
		int elements[] = {34, 6, 43, 325, 62};
		for(int i = 0; i < elements.length-1; i++) {
			elements[i] = elements[index];
			elements[index] = element;
			index += 1;
		}
		System.out.println(Arrays.toString(elements));
	}
	
	//Write a method that returns the nth element of a list. If the index of the element exceeds the list size, return -1
	private static int getNthElement(List<Integer> list, int n) {
		int elementIndex = 2 * (n + 1);
		return elementIndex > list.size() - 1 ? -1 : list.get(elementIndex);
	}

	//Segment a String into a sequence of words in a dictionary
	private static void stringSplit(List<String> dict, String input, String output) {
		/*List<String> dict = Arrays.asList("snake","snakes","and","sand","ladder"); //List of Strings to represent dictionary
		String input = "snakesandladder";*/
        if(input.length() == 0) { //if we have reached the end of the String, print the output String
			System.out.println(output);
			return;
		} else {
			for(int i = 1; i <= input.length(); i++) {
				String prefix = input.substring(0, i); //consider all prefixes of current String
				if(dict.contains(prefix)) { //if the prefix is present in the dictionary,add prefix to the output String and recurse for remaining String
					stringSplit(dict, input.substring(i), output + prefix + " ");
				}
			}
		}
	}
	
	//Find the proper divisors, no of proper divisors and their sum for an input number
	private static void properDivisors() {
		int N = 284;
		int counter = 0;
		int sumOfDivisors = 0;
		System.out.print("Common divisors of " + N + " are ");
		for(int i = 1; i < N; i++) {
			if(N % i == 0) {
				counter++;
				sumOfDivisors += i;
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.println("Number of proper divisors are " + counter);
		System.out.println("Sum of divisors is " + sumOfDivisors);
	}
	
	//Amicable numbers: Euler 21
	private static void amicableNumbers() {
		int numberA = 284;
		int numberB = 220;
		int sumOfProperDivisorsOfNumberA = 0;
		int sumOfProperDivisorsOfNumberB = 0;
		for(int i = 1; i < numberA; i++) {
			if(numberA % i == 0) {
				sumOfProperDivisorsOfNumberA += i;
			}
		}
		for(int i = 1; i < numberB; i++) {
			if(numberB % i == 0) {
				sumOfProperDivisorsOfNumberB += i;
			}
		}
		if(sumOfProperDivisorsOfNumberA == numberB && sumOfProperDivisorsOfNumberB == numberA) {
			System.out.println("The numbers "+ numberA + " and " + numberB + " are Amicable");
		} else {
			System.out.println("The numbers "+ numberA + " and " + numberB + " are NOT Amicable");
		}
	}
	
	//Distinct Powers: Euler 29
	private static void distinctPowersCount() {
		int N = 5;
		Set<BigInteger> distinctPowers = new HashSet<>();
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= N; j++) {
				distinctPowers.add(BigInteger.valueOf(i).pow(j));
			}
		}
		System.out.println(distinctPowers.size());
	}
	
	//Find largest number less than a given number
	private static void numberLessThanInput() {
		int inputNumber = 57;
		int aNumberLessThanGiven = inputNumber - 1;
			System.out.println(aNumberLessThanGiven);
	}
	
	//Find continuous sub array whose sum is equal to given number, approach 1
	/*https://javaconceptoftheday.com/how-to-find-continuous-sub-array-whose-sum-is-equal-to-given-number*/
	private static void subArrayEqualTo1() { //For repo	
		int inputNumber = 60;
		int inputArray[] = {5,10,15,20,6,4,16,8,30};
		int sum = inputArray[0]; //Initializing sum with the first element of the inputArray
		int start = 0; //Initializing starting point with 0
		System.out.println("Continuous sub array of " + Arrays.toString(inputArray) + " whose sum is " + inputNumber + " is " );
		for(int i = 1; i < inputArray.length; i++) { //Iterating through inputArray starting from second element
			sum += inputArray[i]; //Adding inputArray[i] to the current 'sum'
			while(sum > inputNumber && start <= i - 1) { //If sum is greater than inputNumber, while loop executes until sum becomes either smaller than or equal to inputNumber
				sum -= inputArray[start]; //Removing starting elements from the 'sum'
				start++; //Incrementing start by 1
			}
			if(sum == inputNumber) { //If 'sum' is equal to 'inputNumber' then printing the sub array
				for(int j = start; j <= i; j++) {
					System.out.print(inputArray[j] + ", ");
				}
				System.out.println();
			}
		}
	}
		
	//Find continuous sub array whose sum is equal to given number, approach 2
	/*https://javaconceptoftheday.com/how-to-find-continuous-sub-array-whose-sum-is-equal-to-given-number*/
	private static void subArrayEqualTo2() {
		int inputNumber = 60;
		int inputArray[] = {5,10,15,20,6,4,16,8,30};
		int sum = 0; //Initializing 'sum' to 0
		System.out.println("Continuous sub array of " + Arrays.toString(inputArray) + " whose sum is " + inputNumber + " is " );
		for(int i = 0; i < inputArray.length; i++) { //Iterating through 'inputArray'
			sum = inputArray[i]; //Assigning inputArray[i] to 'sum'
			for(int j = i + 1; j < inputArray.length; j++) {
				sum = sum + inputArray[j]; //Adding inputArray[j] to 'sum'
				if(sum == inputNumber) { //If 'sum' is equal to 'inputNumber' then printing the sub array
					for(int k = i; k <= j; k++) {
						System.out.print(inputArray[k] + ", ");
					}
					System.out.println();
				}
				else if(sum < inputNumber) { //if 'sum' is smaller than 'inputNumber', continue the loop
					continue;
				}
				else if(sum > inputNumber) { //if 'sum' is greater than 'inputNumber', then break the loop
					break;
				}
			}
		}
	}
	
	//Find all pairs of elements in an array whose sum is equal to given number
	private static void pairEqualsInput() {
		int array[] = {4,3,6,8,-2,5,11,2};
		int inputNumber = 9;
		System.out.println("Pair that adds upto " + inputNumber + " is ");
		for(int i = 0; i < array.length - 1; i++) {
			for(int j =  i + 1; j < array.length - 1; j++) {
				if(inputNumber == array[i] + array[j]) {
					System.out.println(array[i] + ", " + array[j]);
				}
			}
		}
	}
	
	//Random pair of three elements of an array whose sum is equal to given number
	private static void pairOfThreeToSum() {
		int inputArray[] = {25,30,6,10,15,20,4,35,5};
		int inputSum = 54;
		System.out.println("The pair is ");
		for(int i = 0; i < inputArray.length; i++) {
			for(int j = i + 1; j < inputArray.length; j++) {
				for(int k = j + 1; k < inputArray.length; k++) {
					if(inputSum == inputArray[i] + inputArray[j] + inputArray[k]) {
						System.out.println(inputArray[i] + ", " + inputArray[j] + ", " + inputArray[k]);
					}
				}
			}
		}
	}
	
	//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
	private static void sumOfSquaresSquareOfSum() { //Euler 6
		int sumTill = 10;
		int sum = 0;
		double sumOfSquares = 0;
		double squareOfSum = 0;
		for(int i = 1; i <= sumTill; i++) {
			sum = sum + i;
			double iSquares = Math.pow(i, 2);
			squareOfSum = Math.pow(sum, 2);
			sumOfSquares = sumOfSquares + iSquares;
		}
		System.out.println(sumOfSquares + ", " + squareOfSum + " and their difference is " + (squareOfSum - sumOfSquares));
	}
	
	//Longest Collatz sequence
	private static void collatzSequence() {
		int number = 10;
		System.out.print(number + " ");
		while(number > 1) {
			if(number % 2 == 0) {
				number = number / 2;
			} else if(number % 2 != 0) {
				number = 3 * number + 1;
			}
			System.out.print(number + " ");
		}
	}
	
	//Find an element which divides the array in two sub arrays with equal product
	/*
	 * Input : 2, 3, 4, 1, 4, 6
		Output : 1
		If 1 is the partition, 
		Subarrays are : {2, 3, 4} and {4, 6}
	 */
	private static void subArraysWithEqualProduct() { //https://www.geeksforgeeks.org/find-an-element-which-divides-the-array-in-two-subarrays-with-equal-product
		int array[] = {2, 3, 4, 1, 4, 6};
		int dividingElement = array[1];
		int productPre = 1;
		int productPost = 1;
		for(int i = 0; i < dividingElement - 1; i++) {
			array[productPre] *= array[i];
		}
		for(int j = dividingElement + 1; j < array.length; j++) {
			array[productPost] *= array[j];
		}
		if(productPre != productPost) {
			dividingElement++;
		}
		System.out.println("Diving element is " + array[dividingElement]);	
	}


	public static void main(String[] args) {
		/*List<String> dict = Arrays.asList("snake","snakes","and","sand","ladder"); //List of Strings to represent dictionary
		String input = "snakesandladder";
		System.out.println("Dictionary words are: " + dict);
        System.out.println("String is: " + input);
        stringSplit(dict, input, "");*/
        
		int A[]={8,5,7,6,23,9,1,3,10,4,2,1,2,3,4};
		findAllNonRepeat(A);
		//evenOddCount();
		/*
		findAllNonRepeat(A);
		findAllNonRepeats();
		pairOfInput(A,10);
		maxNo(A);
		oddMultiples(16);
		twoDimArray(3,4);
		double array[] = {34,25,22,66,26,78};
		sumOfArray();
		System.out.println(averageOfArray(array));
		checkEvenOrOdd(5);
		
		first100PrimeNos(100);
		System.out.println(reverseString("palindrome"));
		System.out.println(sumOfNaturalNos(4));
		positiveOrNegative(-1);
		isLeapYear(2020);
		findAsciiOfCharacter('r');
		findRepeatCharacters("embarrassing");
		System.out.println(checkPalindrome("Racecar"));
		checkPalindromeStack("Racecar");
		checkPalindromeQueue("Racecar");
		checkPalindromeFor("Racecar");
		checkPalindromeWhile("Racecar");
		System.out.println(factorialOf(4));
		linearSearch(86); //35, 14, 57, 19, 86, 46, 62
		binarySearch(35);
		fibonacciFor(6);
		tribonacciFor(6);
		fibonacciWhile(8);
		tribonacciWhile(8);
		findSmallest(43,75,82);
		findLargest(93,75,82);
		sentenceReverse("my test sentence is here");
		reverseArray();
		reverseArrayStack();
		findElement(5);
		checkArmstrongNo(665);
		checkArmstrongNo(153);
		System.out.println(findIndexOfElement(34));
		removeElement(2);
		//insertElement(53, 2);
		copyArrayTo();
		secondLargest();
		System.out.println(duplicateElements());
		commonIntegerElements();
		commonStringElements();*/
		//gcdOfNumbers();
		//findMinMaxElements();
		//removeDuplicates();
		//countEvenOdds();
		//majorityDuplicateElement();
		//removeDuplicates();
		//System.out.println(longestSubStringSequence());
		//largestDistanceOfArrayNeighbours();
		//smallestDistanceOfArrayNeighbours();
		//findTopThreeLargest();
		//isAnagram1();
		//System.out.println(isAnagram2());
		//distinctPowersCount();
		//properDivisors();
		//amicableNumbers();
		//subArrayEqualTo1();
		//subArrayEqualTo2();
		//pairEqualsInput();
		//sumOfSquaresSquareOfSum();
		//summationOfPrimes(20);
		//collatzSequence();
		subArraysWithEqualProduct();
	}
}
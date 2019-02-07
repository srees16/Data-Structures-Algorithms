package Algorithms;

/*
Exercises ref from:
https://beginnersbook.com/2017/09/java-examples
https://www.w3resource.com/java-exercises/array/index.php

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class CoreJavaWorkout {

	//Sum of elements of an array
	private static void sumOfArray() {
		int array[] = {5,2,8,6,};
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count = count + array[i];
		}
		System.out.println(count);
	}
	
	//Calculate average of numbers of an Array
	private static double averageOfArray(double numArray[]) {
		double total=0;
		for (int i=0;i<numArray.length;i++) {
			total = total + numArray[i];
		}
		double average = total/numArray.length;
		return average;
	}
	
	//Find max no in array
	private static void maxNo(int a[]) {
		int temp,i;
		for(i=0;i<a.length-1;i++) {
			temp=i;
			if(temp<i) {
				i++;
			}
		}
		System.out.println("Max no of the array is "+a[i]);
	}
	
	//Find non repeating elements or duplicate nos in array
	private static void findAllNonRepeat(int A[]) { //https://www.geeksforgeeks.org/non-repeating-element/
		for(int i=0;i<A.length;i++) {
			int j;
			for(j=0;j<A.length;j++) {
				if(i!=j && A[i]==A[j]) {
					break;
				}
			}
			if(j==A.length) {
				//return A[i];
				System.out.print(A[i]+",");
			}
		}
		//return -1;
	}
	
	private static int[] findAllNonRepeats() { //https://www.sanfoundry.com/java-program-find-number-non-repeated-elements-array
		int flag=0,count=0;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter how many elements in array");
		int n=s.nextInt();
		int A[]=new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++) {
			A[i]=s.nextInt();
		}
		System.out.println("Non repeated elements are:");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i!=j) {
					if(A[i]!=A[j]) {
						flag=1;
					} else {
						flag=0;
						break;
					}
				}
			}
			if(flag==1) {
				count++;
				System.out.println(A[i]+" ");
			}
		}
		s.close();
		System.out.println("No of non repeat elements "+count);
		return A;
	}
	
	private static void pairOfInput(int a[],int no) { //https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x
		HashSet<Integer> hset=new HashSet<>();
		Arrays.sort(a);
		System.out.println("Pair of given no "+no+" is ");
		for(int i=0;i<a.length-1;i++) {
			int temp=no-a[i];
			if(temp>=0 && hset.contains(temp)) {
				System.out.println(temp+", "+a[i]);
			}
			hset.add(a[i]);
		}
	}
	
	private static void arrayOfInput(int a[],int no,int arrayLength) {
		HashSet<Integer> hset=new HashSet<>();
		Arrays.sort(a);
		System.out.println("Pair of given no "+no+" is ");
		for(int i=0;i<a.length-1;i++) {
			int temp=no-a[i];
			if(temp>=0&&hset.contains(temp)) {
				System.out.println(a[i]+", "+temp);
			}
			hset.add(a[i]);
		}
	}
	
	//Sum of multiples of 3 and 5
	static void oddMultiples(int x) {
		int f=0;
		for(int i=1;i<x;i++) {
			if(i%3==0 || i%5==0) {
				f+=i;//f=f+i
				//System.out.println(i);
			}
		}
		System.out.println("Multiples of odd numbers is "+f);
	}

	//Smallest missing positive no. Ref: https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array-set-2
	private static int smallestMissingInteger(int a[]) {
		int v1,v2;
		for(int i=0;i<a.length;i++) {
			if(a[i]<=0||a[i]>a.length) {
				continue;
			} else {
				v1=a[i];
				while(a[v1-1]!=v1) {
					v2=a[v1-1];
					a[v1-1]=v1;
					v1=v2;
					if(v1<=0||v1>a.length) {
						break;
					}
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			if(a[i]!=i+1) {
				return i+1;
			}
		}
		return a.length+1;
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

	//Display prime numbers between 1 and 100 or 1 and n
	private static void first100PrimeNos(int primesUpto) { //Needs improvement
		System.out.print(2 + ", " + 3 + ", " + 5);
		for (int i =5; i < primesUpto; i++) {
			if (i % 2 != 0 && i % 3 != 0 && i % 5 !=0) {
				System.out.print(", " + i);
			}
		} 
	}

	//Reverse a String using Recursion
	public static String reverseString(String word) {
		if (word.length() <= 1) {
			return word;
		} else {
			return reverseString(word.substring(1)) + word.charAt(0);
		}
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

	//Find Sum of Natural Numbers
	private static int sumOfNaturalNos(int numTill) {
		int a = 0;
		for(int i = 1; i <= numTill; i++) {
			a = a + i;
		}
		return a;
	}

	//Check if a number is Positive or Negative
	private static void positiveOrNegative(int number) {
		if(number <= 0) {
			System.out.println("Negative no!");
		} else {
			System.out.println("Positive no!");
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

	//Find duplicate/repeat Characters in a String
	private static void findRepeatCharacters(String word) {
		Map<Character, Integer> characterCountMap = new HashMap<>();
		char characters[] = word.toCharArray();
		for(char ch : characters) {
			if(characterCountMap.containsKey(ch)) {
				characterCountMap.put(ch, characterCountMap.get(ch)+1);
			} else {
				characterCountMap.put(ch, 1);
			}
		}
		Set<Character> keys = characterCountMap.keySet();
		for(Character ch : keys) {
			if(characterCountMap.get(ch) > 1) {
				System.out.println("Character '" + ch + "' repeated " + characterCountMap.get(ch) + " times.");
			}
		}
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
		return factorialOf(n-1) * n;
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

	//Linear Search to search an element in given list of elements
	private static void linearSearch(int findNumber) { //Rework to throw exception for items absent in the list
		int numArray[] = {35, 14, 57, 19, 86, 46, 62};
		for(int i = 0; i < numArray.length; i++) {
			if(numArray[i] == findNumber) {
				System.out.println(findNumber + " is present at location " + (i + 1));
			}
		}
	}

	private static void twoDimArray(int x,int y) {
		for(int i=0;i<x;i++) {
			int a[]=new int[i];
			for(int j=0;j<y;j++) {
				//a[i]=new int[j];
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

	//Reverse the words and also letters in a sentence
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
	private static void gcdOfNumbers(int x, int y) { //
	 
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
		int count =0;
		int y[] = {85,71,67,32,75,5};
		int k[]=new int[x.length+y.length];
		for(int index = 0; index < (x.length+y.length); index++) {
			if(index < x.length)
				k[index] = x[index];
			else{
				k[index]=y[count];
				count+=1;
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

	//Find the largest and smallest elements of an array
	private static void findMinMaxElements() {
		int myArray[] = {98,26,288,78,11,99,500,6};
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
	 	System.out.println("Min is " + mini + " max is " + maxi);
	 	System.out.println("Min is " + min + " max is " + max);
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
		for(int i=0;i<myArray.length;i++){
			int elm = myArray[i];
			for(int j=0;j<myArray.length;j++){
				if(elm>myArray[j]){
					int a = myArray[i];
					myArray[i] = myArray[j];
					myArray[j]=a;
				}
			}
		}
		System.out.println("Max is " + myArray[myArray.length-2] + " min is " + myArray[0]);
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
	
	
	//Find the difference between the largest and smallest values in an array of integers. The length of the array must be 1 and above
	
	
	//Compute the average value of an array of integers except the largest and smallest values
	
	
	/*
	 Find the length of the longest consecutive elements sequence from a given unsorted array of integers.
	Sample array: [49, 1, 3, 200, 2, 4, 70, 5] 
	The longest consecutive elements sequence is [1, 2, 3, 4, 5], therefore the program will return its length 5
	 */
	
	
	//Find the majority element from an given array of integers containing duplicates
	
	
	//Find smallest and second smallest elements of a given array
	
	
	//Remove duplicate elements from an array
	
	
	/*Remove the duplicate elements of a given array and return the new length of the array.
	Sample: [20, 20, 30, 40, 50, 50, 50]. After removing the duplicate elements the program should return 4 as the new length of the array*/
	
	
	//Find the number of even and odd integers in a given array of integers
	

	//The great Main method!
	public static void main(String[] args) {
				
		int A[]={8,5,7,6,23,9,1,3,10,4,2,1,2,3,4};
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
		findMinMaxElements();
		secondLargest();
		System.out.println(duplicateElements());
		commonIntegerElements();
		commonStringElements();*/
	}
}

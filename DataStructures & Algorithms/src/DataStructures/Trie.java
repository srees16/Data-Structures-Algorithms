package DataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Trie { //Same as TrieJavaBlog but improved. Has 2 main methods, can be used which ever required. Minor bugs in printAll method
	
	private TrieNode root;
	
	public Trie() { //main class constructor to initialize root
		root=new TrieNode(' ');
	}
	
	private class TrieNode { //inner class with the root properties
		char data;
		int count;
		boolean isEndOfWord;
		LinkedList<TrieNode> childList;
		
		public TrieNode(char c) { //inner class constructor to initialize root properties
			childList=new LinkedList<>();
			isEndOfWord=false;
			data=c;
			count=0;
		}
		
		public TrieNode getChild(char c) { //inner class method for returning individual characters of a word if present in the Trie
			if(childList!=null) {
				for(TrieNode eachChild:childList) {
					if(eachChild.data==c) {
						return eachChild;
					}
				}
			}
			return null;
		}
	}
	
	public void insert(String word) {
		if(search(word)==true) {
			return;
		}
		TrieNode current=root;
		for(char c:word.toCharArray()) {
			TrieNode child=current.getChild(c);
			if(child!=null) {
				current=child;
			} else {
				current.childList.add(new TrieNode(c));	//if child not present, adding it to the list
				current=current.getChild(c);
			}
			current.count++;
		}
		current.isEndOfWord=true;
	}
	
	public boolean search(String word) {
		TrieNode current=root;
		for(char c:word.toCharArray()) {
			if(current.getChild(c)==null) {
				return false;
			} else {
				current=current.getChild(c);
			}
		}
		if(current.isEndOfWord==true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void remove(String word) {
		if(search(word)==false) {
			System.out.println("The word "+word+" is not present in the Trie");
			return;
		} else {
			TrieNode current=root;
			for(char c:word.toCharArray()) {
				TrieNode child=current.getChild(c);
				if(child.count==1) {
					current.childList.remove(child);
					System.out.println("The word '"+word+"' is successfully deleted from the Trie");
					return;
				} else {
					child.count--;
					current=child;
				}
			}
			current.isEndOfWord=false;
		}
	}
	
	public static void printAllWords(TrieNode root, String s) {
		TrieNode current=root;
		if(root.childList==null || root.childList.size()==0) {
			System.out.println("No words present in the Trie");
			return;
		} else {
			System.out.println("Entries in Trie are: ");
			Iterator<TrieNode> iterator=current.childList.iterator();
			while(iterator.hasNext()) {
				TrieNode node=(TrieNode)iterator.next();
				s+=node.data;
				printAllWords(node,s);
				if(node.isEndOfWord==true) {
					System.out.print(s+" ");
					s=s.substring(0,s.length()-1);
				} else {
					s=s.substring(0,s.length()-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*Trie trie=new Trie();
		trie.insert("bat");
		trie.insert("cat");
		trie.insert("bot");
		trie.insert("bank");
		trie.insert("rat");
		trie.insert("apple");
		trie.insert("match");
		trie.insert("far");
		trie.insert("moon");
		trie.insert("lighting");
		Trie.printAllWords(trie.root, " ");
		trie.remove("bot");
		System.out.println();
		Trie.printAllWords(trie.root, " ");*/
		
		Scanner scan=new Scanner(System.in);
		Trie t=new Trie();
		System.out.println("Welcome to Trie Test");
		char c;
		do {
			System.out.println("Trie Operations:");
			System.out.println("1. Insert String");
			System.out.println("2. Delete String");
			System.out.println("3. Search String");
			System.out.println("4. Print All");
			System.out.println("Choose the operaton you want!");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter String to insert");
				t.insert(scan.next());
				break;
			case 2:
				System.out.println("Enter String to delete");
				try {
					t.remove(scan.next());
				} catch(Exception e) {
					System.out.println(e+" not found!");
				}
				break;
			case 3:
				System.out.println("Enter String to search");
				System.out.println("Search result: "+t.search(scan.next()));
				break;
			case 4:
				Trie.printAllWords(t.root, " ");
				System.out.println();
				break;
			default:
				System.out.println("Wrong Entry!");
				break;
			}
			System.out.println("Do you want to continue?");
			c=scan.next().charAt(0);
		} while(c=='Y' || c=='y');
	}
}
package DataStructures;

import java.util.HashMap;
import java.util.Map;

/*
 * Ref: https://github.com/eugenp/tutorials/tree/master/data-structures
*/


public class Trie1 {

	private class TrieNode {
		
		private final Map<Character, TrieNode> children = new HashMap<>();
		private boolean endOfWord;
		
		private Map<Character, TrieNode> getChildren() {
			return children;
		}
		
		private boolean isEndOfWord() {
			return endOfWord;
		}
		
		private void setEndOfWord(boolean endOfWord) {
			this.endOfWord = endOfWord;
		}
	}
	
	private TrieNode root;
	
	private Trie1() {
		root = new TrieNode();
	}
	
	private void insert(String word) {
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
		}
		current.setEndOfWord(true);
	}
	
	private boolean delete(String word) {
		return delete(root, word, 0);
	}
	
	private boolean delete(TrieNode current, String word, int index) {
		if(index == word.length()) {
			if(!current.isEndOfWord()) {
				return false;
			}
			current.setEndOfWord(false);
			return current.getChildren().isEmpty();
		}
		char ch = word.charAt(index);
		TrieNode node = current.getChildren().get(ch);
		if(node == null) {
			return false;
		}
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();
		if(shouldDeleteCurrentNode) {
			current.getChildren().remove(ch);
			return current.getChildren().isEmpty();
		}
		return false;
	}
	
	private boolean containsNode(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.getChildren().get(ch);
			if(node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord();
	}
	
	private boolean isEmpty() {
		return root == null; 
	}

	public static void main(String[] args) {
		
		
	}

}
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Trie {
	
	// Inner class, Trie ke use ke liye
	private class TrieNode {
		@SuppressWarnings("unused")
		private char data; // node mein store character
		private HashMap<Character, TrieNode> children; // map jismein string ke naam node ke saath hota hai
		private boolean isEnd; // end state
		
		// Constructor
		public TrieNode(char data) {
			this.data = data;
			children = new HashMap<Character, TrieNode>();
			isEnd = false;
		}
		
		// Child ko TrieNode mein add kar rha h 
		public void addChild(char child) {
			children.put(child, new TrieNode(child));
		}
		
		// Wahi TrieNode ayegi jo di gayi character ke similar hai
		public TrieNode getChild(char child) {
			if (!children.keySet().contains(child)) {
				return null;
			}
			
			return children.get(child);
		}
		
		// Child present hai ya nahi, true return karo
		public boolean containsChild(char child) {
			return children.keySet().contains(child);
		}
	}
	
	private TrieNode root;
	private TrieNode curr;
	
	public Trie() {
		root = new TrieNode(' '); // root
		curr = root;
	}
	
	// Ek word ko trie mein insert krne k liye
	public void insert(String s) {
		char letter;
		curr = root;
		
		// Word ke har letter ko tarverse krne k liye
		// Trie ko update karo agar koi letter structure mein nahi hai
		for (int i = 0; i < s.length(); i++) {
			letter = s.charAt(i);
			
			if (!curr.containsChild(letter)) {
				curr.addChild(letter);
			} 
			
			curr = curr.getChild(letter);
		}
		
		//Word k last character ko end mark krne k liye
		curr.isEnd = true;
	}
	
	// Word ke sabhi suffix ki shuruaat ke indices return krne k liye
	public List<Integer> getSuffixesStartIndices(String s) {
		List<Integer> indices = new LinkedList<Integer>(); // indices ko store karne k liye
		char letter;
		curr = root; // root se start karne k liye
		
		for (int i = 0; i < s.length(); i++) {
			letter = s.charAt(i);
			
			// Agar current charcter ke paas koi child nhi h 
			// iska mtlb trie mein abhi relation nahi hai
			// To suffix ki indices return karne k liye
			if (!curr.containsChild(letter))
				return indices;
			
			// Child node mein jane k liye
			curr = curr.getChild(letter);
			
			// Agar character word ka end hai,mtlb character ke baad ek suffix hai
			// To indices ko update karo
			if (curr.isEnd)
				indices.add(i + 1);
		}
		
		return indices;
	}
}

package com.leetcode.p0208_implementtrie;

public class ImplementTrie {
    TrieNode root;
    public ImplementTrie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        if(word==null || word.trim().isEmpty()) return;
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] != null){
                node= node.children[c-'a'];
            } else {
                node.children[c-'a'] = new TrieNode();
                node= node.children[c-'a'];
            }
        }
        node.wordEnds = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
             if(node.children[c-'a'] != null){
                node= node.children[c-'a'];
            } else {
                return false;
            }
        }
        return node.wordEnds;

    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
             if(node.children[c-'a'] != null){
                node= node.children[c-'a'];
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		ImplementTrie trie = new ImplementTrie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // true
		System.out.println(trie.search("app")); // false
		System.out.println(trie.startsWith("app")); // true
		trie.insert("app");
		System.out.println(trie.search("app")); // true
	}
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean wordEnds;

}



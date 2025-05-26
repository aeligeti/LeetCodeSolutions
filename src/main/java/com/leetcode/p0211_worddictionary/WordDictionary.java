package com.leetcode.p0211_worddictionary;

/*
 * LeetCode 211 Word Dictionary
 * 
 * Used recursive DFS to search for words with wildcards.
 * Not the most efficient solution, but works for the problem constraints.
 * will optimize later. 
 */

// TODO: Optimize the search method to avoid unnecessary recursion and improve performance.
public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a']!=null){
                node = node.children[c-'a'];
            }
            else {
                node.children[c-'a'] = new TrieNode();
                node = node.children[c-'a'];
            }
        }
        node.wordEnds = true;
    }
    
    public boolean search(String word) {
        return dfsSearch(word, root);
    }

    public boolean dfsSearch(String word, TrieNode node){
    	boolean result = false;

        if(word==null || word.equals("")) {
			return node.wordEnds; // if word is empty, check if current node is a word end
        }

        
        char[] c = word.toCharArray();
        if(c[0]!='.' && node.children[c[0]-'a']==null){
            return false;
        }
        else if(c[0]=='.'){
            for(int idx =0; idx<node.children.length; idx++){
            	if(node.children[idx]!=null) {
            		result = result || dfsSearch(word.substring(1), node.children[idx]);
            	}
               
            }
            return result;
        }
        
        
        
        return result || dfsSearch(word.substring(1), node.children[c[0]-'a']); 

    }
    
    //test main method
    public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		wordDictionary.addWord("at");
		System.out.println(wordDictionary.search("pad")); // false
		System.out.println(wordDictionary.search("bad")); // true
		System.out.println(wordDictionary.search(".ad")); // true
		System.out.println(wordDictionary.search("b..")); // true
		System.out.println(wordDictionary.search("a")); // false
    }
} 

class TrieNode {

    TrieNode[] children = new TrieNode[26];
    boolean wordEnds;
}


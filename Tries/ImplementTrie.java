// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

// Implement the Trie class:

// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

// Example 1:

// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
 

// Constraints:

// 1 <= word.length, prefix.length <= 2000
// word and prefix consist only of lowercase English letters.
// At most 3 * 104 calls in total will be made to insert, search, and startsWith.

import java.util.* ;

class Node {
    HashMap<Character,Node> children ;
    boolean isTerminal ; 
    Node(){
        this.children  = new HashMap<>() ; 
        this.isTerminal = false  ; 
    }
}


class Trie {
    Node root ; 
    public Trie() {
        root = new Node() ; 
        
    }
    
    public void insert(String word) {
        Node curr = this.root ; 
        for(Character c:word.toCharArray()){
            if (!curr.children.containsKey(c)){
                curr.children.put(c , new Node()) ; 
            }
            curr = curr.children.get(c) ; 
        }
        curr.isTerminal = true ; 
    }
    
    public boolean search(String word) {
        Node curr = this.root ; 
        for(Character c : word.toCharArray()){
            if (!curr.children.containsKey(c)) return false ; 
            curr = curr.children.get(c);
        }
        return curr.isTerminal ; 
    }
    
    public boolean startsWith(String prefix) {
        Node curr = this.root ; 
        for(Character c : prefix.toCharArray()) {
            if(!curr.children.containsKey(c)) return false ;
            curr = curr.children.get(c) ; 
        }
        return true ; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
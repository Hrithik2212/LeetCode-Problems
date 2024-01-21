// Design a data structure that supports adding new words and finding if a string matches any previously added string.

// Implement the WordDictionary class:

// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

// Example:

// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True
 

// Constraints:

// 1 <= word.length <= 25
// word in addWord consists of lowercase English letters.
// word in search consist of '.' or lowercase English letters.
// There will be at most 2 dots in word for search queries.
// At most 104 calls will be made to addWord and search.

import java.util.*;

class WordDictionary {

    class Node{
        HashMap<Character , Node> children ; 
        boolean isTerminal ; 
        Node(){
            this.children = new HashMap<>() ; 
            this.isTerminal = false ; 
        }
    }

    Node root ; 
    public WordDictionary() {
        this.root = new Node() ; 
    }
    
    public void addWord(String word) {
        Node curr = this.root ; 
        for(Character c: word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c , new Node()) ; 
            }
            curr = curr.children.get(c) ; 
        }
        curr.isTerminal = true ; 
    }
    
    public boolean search(String word) {
        return dfs(this.root , 0 , word ) ; 
    }

    public boolean dfs(Node curr, int j, String word) {
        if (j == word.length()) {
            return curr.isTerminal;
        }
        Character c = word.charAt(j);
        if (c == '.') {
            for (Node child : curr.children.values()) {
                if (child != null && dfs(child, j + 1, word)) {
                    return true;
                }
            }
            return false;
        } 
        else {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            return dfs(curr.children.get(c), j + 1, word);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
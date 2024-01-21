// Given an m x n board of characters and a list of strings words, return all words on the board.

// Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

// Example 1:


// Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
// Output: ["eat","oath"]
// Example 2:


// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []
 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] is a lowercase English letter.
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] consists of lowercase English letters.
// All the strings of words are unique.


import java.util.* ; 

class Solution {
    class Node {
    HashMap<Character , Node > children ; 
    boolean isTerminal ; 
    Node() { 
        children = new HashMap<>() ;
        isTerminal = false ; 
    }
}

    class Trie {
        Node root ; 
        public Trie() {
            this.root = new Node() ; 
        }
        
        public void insert(String word) {
            Node curr = this.root ; 
            for(Character c : word.toCharArray()) { 
                if(!curr.children.containsKey(c))   
                    curr.children.put(c , new Node()) ; 
                curr  = curr.children.get(c) ; 
            }
            curr.isTerminal = true; 
        }

        public boolean search(String word){
            Node curr = this.root ; 
            for(Character c  : word.toCharArray()) { 
                if(!curr.children.containsKey(c))
                    return false ; 
                curr = curr.children.get(c) ; 
            }
            return curr.isTerminal ; 
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie wordDictionary = new Trie() ; 
        boolean vis[][] = new boolean[board.length][board[0].length]; 
        for(int r = 0 ; r < board.length ; r++) {
            for(int c=0; c < board[0].length ; c++ ){
                dfs(board , vis , r , c , wordDictionary , "") ; 
            }
        }

        // Search for the word in Trie ; 
        List<String> res = new ArrayList<>() ; 
        for(String s : words ){
            if(wordDictionary.search(s)) res.add(s) ; 
        }
        return res ; 
    }

    public void dfs(char[][] board ,boolean[][] vis ,int r , int c ,Trie wordDictionary , String word) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || vis[r][c] ) return ; 
        word = word + Character.toString(board[r][c]) ; 
        wordDictionary.insert(word) ; 
        vis[r][c] = true ; 
        dfs(board , vis ,  r-1 , c , wordDictionary , word ); 
        dfs(board , vis , r , c-1 , wordDictionary , word ) ; 
        dfs(board , vis , r+1 , c , wordDictionary , word ) ; 
        dfs(board , vis , r , c+1 , wordDictionary , word ) ; 
        vis[r][c] = false ; 
    }
}


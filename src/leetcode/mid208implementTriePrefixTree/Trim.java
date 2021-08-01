package leetcode.mid208implementTriePrefixTree;

import java.util.HashSet;
import java.util.Set;

//1.hashset实现
//class Trie {
//    Set<String> data;
//    /** Initialize your data structure here. */
//    public Trie() {
//        data=new HashSet<>();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        data.add(word);
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        return data.contains(word);
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        for(String s:data){
//            if(prefix.length()>s.length())continue;
//            if(prefix.charAt(0)==s.charAt(0)){
//                int i=0;
//                while(i<prefix.length()){
//                    if(prefix.charAt(i)!=s.charAt(i))break;
//                    i++;
//                }
//                if(i==prefix.length())return true;
//            }
//        }
//        return false;
//    }
//}
//2.多叉树实现
class TrieNode{
    public boolean isend;
    public TrieNode[] next;
    public TrieNode(){
        next=new TrieNode[26];
    }
}

class Trie {
    TrieNode node;
    /** Initialize your data structure here. */
    public Trie() {
        node=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=node;
        for(int i=0;i<word.length();i++){
            //根节点没有这个字符
            if(cur.next[word.charAt(i)-'a']==null){
                cur.next[word.charAt(i)-'a']=new TrieNode();
            }
            cur=cur.next[word.charAt(i)-'a'];
        }
        cur.isend=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur=node;
        for(int i=0;i<word.length();i++){
            if(cur.next[word.charAt(i)-'a']==null)return false;
            cur=cur.next[word.charAt(i)-'a'];
        }
        return cur.isend;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur=node;
        for(int i=0;i<prefix.length();i++){
            if(cur.next[prefix.charAt(i)-'a']==null)return false;
            cur=cur.next[prefix.charAt(i)-'a'];
        }
        return true;
    }
}
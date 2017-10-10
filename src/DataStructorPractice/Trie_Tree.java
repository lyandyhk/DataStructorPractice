package DataStructorPractice;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author Febiven
 *
 *
 * 字典树
 * 	其中root节点为根，不存放任何信息
 */
public class Trie_Tree {
	private TrialNode root;
	public Trie_Tree(String s) {
		root = new TrialNode('S', 0);
		addString(s);
	}
	//添加单词到树中
	public void addString(String s){
		char[] str = s.toCharArray();
		TrialNode temp = root;
		for(int i=0;i<str.length;i++){
			temp = temp.addNext(str[i]);
		}
	}
	//查看单词在树中是否存在
	public TrialNode isExist(String s){
		char[] str = s.toCharArray();
		TrialNode temp = root;
		for(int i=0;i<str.length;i++){
			if(temp == null)
				return null;
			temp = temp.getNextNode(str[i]);
		}
		return temp;
	}
	//看以此为前缀的单词是否存在
	public boolean isPrefixExist(String s){
		TrialNode node = isExist(s);
		if(node == null)
			return false;
		else 
			return node.getNext() != null;
	}
	//查看字典树中录入了多少个以此开头的单词（相同单词也算）
	public int countOfString(String s){
		TrialNode node = isExist(s);
		return node.getCount();
	}
	//格式化树
	public boolean cleanTree(){
		return root.CleanNext();
	}
	public static void main(String[] args) {
		Trie_Tree tree = new Trie_Tree("abcdeee");
		tree.addString("abcdefg");
		tree.addString("abcdfaw");
		tree.addString("qwesadwe");
		System.out.println(tree.isPrefixExist("abcde"));
	}
	
}
//字典树树节点数据结构
class TrialNode{
	private char word;//对应字符
	private int count;//从根节点开始的字符到此字符位置一共被录入了多少次
	private Map<Character, TrialNode> next;//子节点Map，键是子节点的字符，值是子节点
	public TrialNode(char word, int count) {
		this.word = word;
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public char getWord() {
		return word;
	}
	public void addCount() {
		count++;
	}
	public void setWord(char word) {
		this.word = word;
	}
	public Map<Character, TrialNode> getNext() {
		return next;
	}
	public TrialNode getNextNode(char c) {
		if(next == null)
			return null;
		return next.get(c);
	}
	public TrialNode addNext(char c) {
		if(next == null){
			next = new HashMap<Character, TrialNode>();
			next.put(c, new TrialNode(c, 1));
		}else if(next.containsKey(c)){
			this.getNextNode(c).addCount();
		}else{
			next.put(c, new TrialNode(c, 1));
		}
		return this.getNextNode(c);	
	}
	public boolean CleanNext(){
		next = null;
		return true;
	}
}
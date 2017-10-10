package DataStructorPractice;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author Febiven
 *
 *
 * �ֵ���
 * 	����root�ڵ�Ϊ����������κ���Ϣ
 */
public class Trie_Tree {
	private TrialNode root;
	public Trie_Tree(String s) {
		root = new TrialNode('S', 0);
		addString(s);
	}
	//��ӵ��ʵ�����
	public void addString(String s){
		char[] str = s.toCharArray();
		TrialNode temp = root;
		for(int i=0;i<str.length;i++){
			temp = temp.addNext(str[i]);
		}
	}
	//�鿴�����������Ƿ����
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
	//���Դ�Ϊǰ׺�ĵ����Ƿ����
	public boolean isPrefixExist(String s){
		TrialNode node = isExist(s);
		if(node == null)
			return false;
		else 
			return node.getNext() != null;
	}
	//�鿴�ֵ�����¼���˶��ٸ��Դ˿�ͷ�ĵ��ʣ���ͬ����Ҳ�㣩
	public int countOfString(String s){
		TrialNode node = isExist(s);
		return node.getCount();
	}
	//��ʽ����
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
//�ֵ������ڵ����ݽṹ
class TrialNode{
	private char word;//��Ӧ�ַ�
	private int count;//�Ӹ��ڵ㿪ʼ���ַ������ַ�λ��һ����¼���˶��ٴ�
	private Map<Character, TrialNode> next;//�ӽڵ�Map�������ӽڵ���ַ���ֵ���ӽڵ�
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
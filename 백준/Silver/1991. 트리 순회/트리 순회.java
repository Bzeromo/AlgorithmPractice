import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static Node head = new Node('A', null, null);
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, root,left,right);
		}
		
		preOrder(head);
		sb.append("\n");
		inOrder(head);
		sb.append("\n");
		postOrder(head);
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	
	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static void insertNode(Node temp, char root, char left, char right) {
		
		
		if (temp.value == root) {
			temp.left = (left == '.' ? null : new Node(left,null,null));
			temp.right = (right == '.' ? null : new Node(right,null,null)); 
		}
		else {
			if(temp.left != null) insertNode(temp.left, root, left, right);
			if(temp.right != null) insertNode(temp.right, root, left, right);
		}
	}
	
	public static void preOrder(Node node) {
		if(node ==null) return;
		sb.append(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node ==null) return;
		inOrder(node.left);
		sb.append(node.value);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node ==null) return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.value);
	}

}
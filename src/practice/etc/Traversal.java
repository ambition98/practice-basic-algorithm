package practice.etc;

public class Traversal {
	public static void main(String[] args) {
		Node n1 = new Node(4);
		Node n2 = new Node(5);
		Node n3 = new Node(6);
		Node n4 = new Node(7);
		Node n5 = new Node(2, n1, n2);
		Node n6 = new Node(3, n3, n4);
		Node root = new Node(1, n5, n6);
		
		System.out.println("preOrder");
		preOrder(root);
		System.out.println("\ninOrder");
		inOrder(root);
		System.out.println("\npostOrder");
		postOrder(root);
		
	}
	
	private static void preOrder(Node node) {
		if(node == null)
			return;
		
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private static void inOrder(Node node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	private static void postOrder(Node node) {
		if(node == null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	private static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
		}
		
		Node(int value, Node left, Node right) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
		
		void addLeft(Node node, int value) {
			node.left = new Node(value);
		}
		
		void addRight(Node node, int value) {
			node.right = new Node(value);
		}
	}
	
}

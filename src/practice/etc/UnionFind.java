package practice.etc;

public class UnionFind {

	public static void main(String[] args) {
		int[] parent = new int[11]; //인덱스는 노드, 값은 부모인덱스를 나타낸다
		for(int i=1; i<parent.length; i++)
			parent[i] = i; //부모를 자기자신(연결되지 않은 상태)으로 초기화, 0은 사용하지 않음
		
		printArr(parent);
		System.out.println();
		
		unionParent(parent, 1, 2);
		unionParent(parent, 2, 3);
		unionParent(parent, 4, 5);
		unionParent(parent, 5, 6);
		printArr(parent);
		
		System.out.println(isSameUnion(parent, 1, 3));
		System.out.println(isSameUnion(parent, 1, 4));
		
	}
	
	//재귀호출로 실제 부모를 찾음
	public static int getParent(int[] parent, int n) {
		if(parent[n] == n)
			return n;
		
		return parent[n] = getParent(parent, parent[n]);
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		
		if(aParent < bParent)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static boolean isSameUnion(int[] parent, int a, int b) {
		int aParent = getParent(parent, a);
		int bParent = getParent(parent, b);
		
		if(aParent == bParent) 
			return true;
		else
			return false;
	}
	
	private static void printArr(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			System.out.print(String.format("%-2d", i));
		}
		System.out.println();
		
		for(int i=1; i<arr.length; i++) {
			System.out.print(String.format("%-2d", arr[i]));
		}
		System.out.println();
	}
}

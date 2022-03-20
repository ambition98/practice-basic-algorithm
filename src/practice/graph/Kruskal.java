package practice.graph;

import java.util.ArrayList;
import java.util.Collections;

import practice.etc.UnionFind;

public class Kruskal {

	public static void main(String[] args) {
		int vertex = 8;
		int edge = 11;
		
		ArrayList<Edge> edgeList = new ArrayList<Edge>(edge);
		edgeList.add(new Edge(1, 7, 12));
		edgeList.add(new Edge(1, 4, 28));
		edgeList.add(new Edge(1, 2, 67));
		edgeList.add(new Edge(1, 5, 17));
		edgeList.add(new Edge(2, 4, 24));
		edgeList.add(new Edge(2, 5, 62));
		edgeList.add(new Edge(3, 5, 20));
		edgeList.add(new Edge(3, 6, 37));
		edgeList.add(new Edge(4, 7, 13));
		edgeList.add(new Edge(5, 6, 45));
		edgeList.add(new Edge(5, 7, 73));
		
		Collections.sort(edgeList);
		
		int[] parent = new int[vertex];
		for(int i=0; i<parent.length; i++)
			parent[i] = i;
		
		int totalDistance = 0;
		for(int i=0; i<edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			if(!UnionFind.isSameUnion(parent, e.node[0], e.node[1])) {
				totalDistance += e.distance;
				UnionFind.unionParent(parent, e.node[0], e.node[1]);
			}
		}
		
		System.out.println("비용: " + totalDistance);
		
	}
	
	private static class Edge implements Comparable<Edge> {
		int[] node = new int[2];
		int distance;
		
		public Edge(int a, int b, int distance) {
			this.node[0] = a;
			this.node[1] = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
}

package practice.graph;

import java.util.Stack;

public class DFS {
	public static void main(String[] args) {
		Stack<Pos> stack = new Stack<>();
		
		int mazeSize = 6;
		boolean[][] isVisited = new boolean[mazeSize][mazeSize];
		int[][] maze = { {1, 1, 1, 1, 1, 1}
						,{0, 0, 1, 0, 0 ,1}
						,{1, 0, 0, 0, 1, 1}
						,{1, 0, 1, 0, 1, 1}
						,{1, 0, 1, 0, 0, 0}
						,{1, 1, 1, 1, 1, 1}};
		// 0: 길, 1: 벽, 출발지: [1][0], 도착지: [4][6]
		
		boolean isSucceed = false;
		Pos start = new Pos(1, 0);
		Pos end = new Pos(4, 5);
		
		stack.push(start);
		while(!stack.isEmpty()) {
			Pos currentPos = stack.pop();
			int x = currentPos.x;
			int y = currentPos.y;
			isVisited[x][y] = true;
			System.out.println("[Current position] x: " + currentPos.x + ", y: " + currentPos.y);
			if(currentPos.equals(end)) {
				isSucceed = true;
				break;
			}
			
			if(x-1 >= 0 && maze[x-1][y] == 0 && isVisited[x-1][y] == false) {
				stack.push(new Pos(x-1, y));
			}
			
			if(x+1 < maze.length && maze[x+1][y] == 0 && isVisited[x+1][y] == false) {
				stack.push(new Pos(x+1, y));
			}
			
			if(y-1 >= 0 && maze[x][y-1] == 0 && isVisited[x][y-1] == false) {
				stack.push(new Pos(x, y-1));
			}
			
			if(y+1 < maze.length && maze[x][y+1] == 0 && isVisited[x][y+1] == false) {
				stack.push(new Pos(x, y+1));
			}
		}
		
		if(isSucceed)
			System.out.println("탈출 성공");
		else
			System.out.println("탈출구가 없는 미로입니다.");
	}
	
	private static class Pos {
		int x;
		int y;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Pos obj) {
			return (this.x == obj.x) && (this.y == obj.y);
		}
	}
}

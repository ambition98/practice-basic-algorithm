package search;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		Queue<Pos> queue = new LinkedList<Pos>();
		
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
		
		queue.add(start);
		while(!queue.isEmpty()) {
			Pos currentPos = queue.poll();
			int x = currentPos.x;
			int y = currentPos.y;
			
			isVisited[x][y] = true;
			
			System.out.println("[Current position] x: " + currentPos.x + ", y: " + currentPos.y);
			
			if(currentPos.equals(end)) {
				isSucceed = true;
				break;
			}
			
			
			if(x-1 >= 0 && maze[x-1][y] == 0 && isVisited[x-1][y] == false) {
//				isVisited[x-1][y] = true;
				queue.add(new Pos(x-1, y));
			}
			
			if(x+1 < maze.length && maze[x+1][y] == 0 && isVisited[x+1][y] == false) {
//				isVisited[x+1][y] = true;
				queue.add(new Pos(x+1, y));
			}
			
			if(y-1 >= 0 && maze[x][y-1] == 0 && isVisited[x][y-1] == false) {
//				isVisited[x][y-1] = true;
				queue.add(new Pos(x, y-1));
			}
			
			if(y+1 < maze.length && maze[x][y+1] == 0 && isVisited[x][y+1] == false) {
//				isVisited[x][y+1] = true;
				queue.add(new Pos(x, y+1));
			}
			
		}
		
		if(isSucceed)
			System.out.println("탈출 성공");
		else
			System.out.println("탈출구가 없는 미로입니다.");
	}
	
}
class Pos {
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Pos obj) {
		return (this.x == obj.x) && (this.y == obj.y);
	}
}

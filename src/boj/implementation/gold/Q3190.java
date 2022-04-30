package boj.implementation.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q3190 {
    public static void main(String[] args) throws Exception {
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};
        int moveIdx = 1; //시작은 오른쪽 방향
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Set<Pos> applePos = new HashSet<>(k);
        Queue<Pos> snakeBody = new LinkedList<>();
        Pos head = new Pos(0, 0);

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            applePos.add(new Pos(x, y));
        }

        int l = Integer.parseInt(br.readLine());
        Queue<Move> moveQueue = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            moveQueue.offer(new Move(time, direction));
        }

        boolean isEnd = false;
        int currentTime = 0;

        Move nextMove = moveQueue.poll();
        while (!isEnd) {
            currentTime++;

            Pos nextHead = new Pos(head.x + moveX[moveIdx], head.y + moveY[moveIdx]);
            isEnd = isEnd(nextHead, n, snakeBody);

            snakeBody.offer(head);
            if (applePos.contains(nextHead)) {
                //사과가 있을 경우 기존 몸은 움직이지 않고 추가만 됨
                applePos.remove(nextHead);
            } else {
                //사과가 없을 경우 몸 전체를 움직임
                snakeBody.poll();
            }

            head = nextHead;

            if (nextMove != null && currentTime == nextMove.moveTime) {
                moveIdx = changeMoveIdx(nextMove.direction, moveIdx);
                nextMove = moveQueue.poll();
            }
        }

        System.out.println(currentTime);

    }

    private static int changeMoveIdx(char c, int idx) {
        if (c == 'D')
            idx++;
        else
            idx--;

        if (idx > 3)
            idx = 0;

        if (idx < 0)
            idx = 3;

        return idx;

    }

    private static boolean isEnd(Pos head, int n, Queue<Pos> snakeBody) {
        int x = head.x;
        int y = head.y;
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return true; //머리가 벽에 충돌
        }

        return snakeBody.contains(head); // 머리가 몸에 충돌
    }

    private static class Move {
        private final int moveTime;
        private final char direction;

        public Move(int moveTime, char direction) {
            this.moveTime = moveTime;
            this.direction = direction;
        }
    }

    private static class Pos {
        private final int x;
        private final int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pos) {
                Pos p = (Pos) o;
                return this.x == p.x && this.y == p.y;

            } else {
                return false;
            }
        }
    }
}

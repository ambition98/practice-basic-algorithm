package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q42885 {
    private int solution(int[] people, int limit) {
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(people);

        for (int i=people.length - 1;i>=0; i--) {
            if (queue.isEmpty()) {
                cnt++;
                queue.offer(limit - people[i]);
            } else {
                if (queue.peek() >= people[i]) {
                    queue.poll();
                } else {
                    cnt++;
                    queue.offer(limit - people[i]);
                }
            }
        }

        return cnt;
    }
}

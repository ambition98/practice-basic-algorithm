package programmers.level2

import java.util.LinkedList

private class `154538` {
    class Solution {
        fun solution(x: Int, y: Int, n: Int): Int {
            val queue = LinkedList<Pair<Int, Int>>()
            queue.offer(Pair(y, 0))

            while(queue.isNotEmpty()) {
                val p = queue.poll()
                // println("x: ${p.first}, cnt: ${p.second}")
                if (p.first % 3 == 0 && p.first / 3 >= x) {
                    queue.offer(Pair(p.first / 3, p.second + 1))
                }
                if (p.first % 2 == 0 && p.first / 2 >= x) {
                    queue.offer(Pair(p.first / 2, p.second + 1))
                }
                if (p.first - n >= x) {
                    queue.offer(Pair(p.first - n, p.second + 1))
                }

                if (p.first == x) {
                    return p.second
                }
            }

            return -1
        }
    }
}
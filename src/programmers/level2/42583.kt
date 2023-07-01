package programmers.level2

private class `42583` {
    class Solution {
        fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
            val queue = ArrayDeque<Pair<Int, Int>>()
            var cTime = 0
            var cWeight = 0
            var cLength = 0
            var idx = 0
            var passed = 0

            while (passed < truck_weights.size) {
                cTime++

                if (queue.isNotEmpty() && queue.first().second >= bridge_length) {
                    val truck = queue.removeFirst()
                    passed++
                    cLength--
                    cWeight -= truck.first
                }

                for (i in queue.indices) {
                    val p = queue[i]
                    queue[i] = Pair(p.first, p.second + 1)
                }

                if (idx in truck_weights.indices
                    && cWeight + truck_weights[idx] <= weight
                    && cLength + 1 <= bridge_length) {
                    queue.addLast(Pair(truck_weights[idx], 1))
                    cLength++
                    cWeight += truck_weights[idx++]
                }
            }

            return cTime
        }
    }
}
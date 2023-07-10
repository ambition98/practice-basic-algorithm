package programmers.level2

private class `118667` {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = ArrayDeque<Int>()
        val q2 = ArrayDeque<Int>()
        var sum1 = 0L
        var sum2 = 0L
        var res = 0

        for (i in queue1.indices) {
            q1.add(queue1[i])
            q2.add(queue2[i])
            sum1 += queue1[i].toLong()
            sum2 += queue2[i].toLong()
        }

        if ((sum1 + sum2) % 2L != 0L) return -1

        for (i in queue1.indices) {
            while (sum1 < sum2) {
                q1.add(q2.removeFirst())
                sum1 += q1.last()
                sum2 -= q1.last()
                res++
            }

            while (sum1 > sum2) {
                q2.add(q1.removeFirst())
                sum1 -= q2.last()
                sum2 += q2.last()
                res++
            }

            if (sum1 == sum2) return res
        }

        return -1
    }
}
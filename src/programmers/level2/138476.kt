package programmers.level2

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
private class `138476` {
    fun solution(k: Int, tangerine: IntArray): Int {
        var res = 0
        var current = 0

        tangerine.groupBy { it }.toList().sortedByDescending { it.second.size }.forEach {
            res++
            current += it.second.size
            if (current >= k)
                return res
        }

        return res
    }
}
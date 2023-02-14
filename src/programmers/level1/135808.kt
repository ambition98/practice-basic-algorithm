package programmers.level1

private class `135808` {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var res = 0
        var cnt = 0
        score.sortDescending()
        score.forEach {
            cnt++
            if (cnt == m) {
                res += it * m
                cnt = 0
            }
        }

        return res
    }
}
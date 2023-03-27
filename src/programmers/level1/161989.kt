package programmers.level1

private class `161989` {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var idx = 0
        var cnt = 0
        section.forEach {
            if (it > idx) {
                idx = it + m - 1
                cnt++
            }
        }

        return cnt
    }
}
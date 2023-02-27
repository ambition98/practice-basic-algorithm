package programmers.level2

import kotlin.math.abs
import kotlin.math.max

//https://school.programmers.co.kr/learn/courses/30/lessons/12985
private class `12985` {
    fun solution(n: Int, a: Int, b: Int): Int {
        var cnt = 1
        var x = a
        var y = b
        while (abs(x - y) != 1 || max(x, y) % 2 != 0) {
            x = if (x % 2 == 0) x / 2 else x / 2 + 1
            y = if (y % 2 == 0) y / 2 else y / 2 + 1
            cnt++
        }

        return cnt
    }
}
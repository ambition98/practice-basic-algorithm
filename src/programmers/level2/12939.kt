package programmers.level2

import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

//https://school.programmers.co.kr/learn/courses/30/lessons/12939
private class `12939` {
    fun solution(s: String): String {
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        val st = StringTokenizer(s)
        while (st.hasMoreTokens()) {
            val n = st.nextToken().toInt()
            max = max(max, n)
            min = min(min, n)
        }
        return "$min $max"
    }
}
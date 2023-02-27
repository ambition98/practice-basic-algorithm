package programmers.level2

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

//https://school.programmers.co.kr/learn/courses/30/lessons/42842
private class `42842` {
    fun solution(brown: Int, yellow: Int): IntArray {
        getPair(yellow).forEach {
            if ((it.first + 2) * (it.second + 2) == brown + yellow)
                return intArrayOf(it.first + 2, it.second + 2)
        }
        return intArrayOf(0)
    }

    fun getPair(n: Int): List<Pair<Int, Int>> {
        val divider = ArrayList<Int>()
        val res = ArrayList<Pair<Int, Int>>()
        val sqrt = sqrt(n.toDouble()).toInt()
        for (i in 1..sqrt) {
            if (n % i == 0) divider.add(i)
        }

        for (i in 0..divider.size) {
            divider.add(n / divider[i])
        }

        if (sqrt * sqrt == n) divider.removeLast()

        for (i in divider.indices) {
            for (j in i+1..divider.lastIndex) {
                if (divider[i] * divider[j] == n) {
                    val p = Pair(max(divider[i], divider[j]), min(divider[i], divider[j]))
                    res.add(p)
                }
            }
        }

        return res
    }
}
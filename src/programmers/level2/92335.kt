package programmers.level2

import kotlin.math.sqrt

private class `92335` {
    fun solution(n: Int, k: Int): Int {
        var cnt = 0
        val s = convert(n, k)
        s.split('0').forEach {
            if (it.length > 0) {
                cnt += check(it.toLong())
            }
        }

        return cnt
    }

    fun convert(n: Int, k: Int): String {
        val sb = StringBuilder()
        var num = n
        while (num / k >= 1) {
            sb.append(num % k)
            num /= k
        }
        sb.append(num)

        return sb.reversed().toString()
    }

    fun check(n: Long): Int {
        if (n < 2) return 0.toInt()

        val sqrt = sqrt(n.toDouble()).toLong()
        for (i in 2..sqrt) {
            if (n % i == 0L) {
                return 0.toInt()
            }
        }

        return 1.toInt()
    }
}
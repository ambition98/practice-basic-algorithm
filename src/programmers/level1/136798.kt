package programmers.level1

import kotlin.math.sqrt

//https://school.programmers.co.kr/learn/courses/30/lessons/136798
/*
    n의 약수 구하기 알고리즘
    1. 1부터 n제곱근 까지 탐색 후, 나머지가 0인 수를 찾는다. (n 약수의 일부)
    2. n을 구해진 수로 나눈 수가 나머지 약수의 일부다
    3. n제곱근 * n제곱근 = n 일 경우 중복이 생기므로 삭제한다.

    e.g. n = 100 일 때,
    1. (1..sqrt(100)) 범위 탐색
    결과: 1, 2, 4, 5, 10

    2. 100 에 나온 수로 나눈다
    결과: 100, 50, 25, 20, 10

    10이 중복되므로 지우면 100의 약수는
    1, 2, 3, 5, 10, 20, 25, 50, 100 이 된다.
 */
private class `136798` {
    fun solution(number: Int, limit: Int, power: Int): Int {
        if (number == 1) return 1
        var res = 1
        (2..number).forEach {
            res += getPower(it, limit, power)
        }

        return res
    }

    fun getPower(n: Int, limit: Int, power: Int): Int {
        var cnt = 1
        val sqrt = sqrt(n.toDouble()).toInt()
        for (i in 2..sqrt) {
            if (n % i == 0) {
                cnt++
            }
        }
        cnt *= 2
        if (sqrt * sqrt == n) cnt--
        if (cnt > limit) return power
        return cnt
    }
}
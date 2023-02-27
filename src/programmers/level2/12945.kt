package programmers.level2

//https://school.programmers.co.kr/learn/courses/30/lessons/12945
private class `12945` {
    fun solution(n: Int) = fibo(n)

    tailrec fun fibo(n: Int, step: Int = 2, total: IntArray = intArrayOf(0, 1)): Int {
        return if (n == step)
            (total[0] + total[1]) % 1234567
        else
            fibo(n, step + 1, intArrayOf(total[1], (total[0] % 1234567 + total[1] % 1234567) % 1234567))
    }
}
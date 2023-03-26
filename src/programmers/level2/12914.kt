package programmers.level2

//https://school.programmers.co.kr/learn/courses/30/lessons/12914
private class `12914` {
    fun solution(n: Int) = getNum(n)

    tailrec fun getNum(n: Int, acc: Long = 1, prevSum: Long = 2): Long {
        return if (n == 1) acc
        else getNum(n - 1, prevSum, (prevSum + acc) % 1234567)
    }
}
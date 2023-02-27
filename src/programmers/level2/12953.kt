package programmers.level2

//https://school.programmers.co.kr/learn/courses/30/lessons/12953
private class `12953` {
    fun solution(arr: IntArray)
            = arr.fold(1) { sum, i -> sum + (sum * i / gcd(sum, i)) }

    tailrec fun gcd(a: Int, b: Int): Int {
        return if (b == 0) return a
        else gcd(b, a % b)
    }
}
package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/142086
private class `142086` {
    fun solution(s: String): IntArray {
        val res = IntArray(s.length)
        res[0] = -1
        for (i in s.indices) {
            for (j in i-1 downTo 0) {
                if (j==0 && s[i] != s[j])
                    res[i] = -1
                if (s[i] == s[j]) {
                    res[i] = i-j
                    break
                }
            }
        }

        return res
    }
}
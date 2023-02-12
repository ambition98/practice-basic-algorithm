package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/140108
private class `140108` {
    fun solution(s: String): Int {
        var e = 0
        var ne = 0
        var res = 0
        var c = s[0]
        var i = 0
        while (i < s.length) {
            val t = s[i]
            if (c == t) e++
            else ne++

            if (e == ne) {
                if (i + 1 >= s.length) break
                res++
                e = 0
                ne = 0
                c = s[i + 1]
            }
            i++
        }

        if (e != 0 || ne != 0) res++

        return res
    }
}
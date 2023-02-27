package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/131128
private class `131128` {
    fun solution(X: String, Y: String): String {
        val res = ArrayList<Char>()
        val map = HashMap<Char, Int>()
        var onlyZero = true
        var cnt = 0
        X.forEach {
            if (map.contains(it))
                map[it] = map.getValue(it) + 1
            else
                map[it] = 1
        }
        Y.forEach {
            if (map.contains(it) && map.getValue(it) > 0) {
                if (onlyZero && it != '0') onlyZero = false
                cnt++
                map[it] = map.getValue(it) - 1
                res.add(it)
            }
        }

        if (cnt < 1) return "-1"
        if (onlyZero) return "0"

        res.sortDescending()
        return res.joinToString("")
    }
}
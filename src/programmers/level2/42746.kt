package programmers.level2

//https://school.programmers.co.kr/learn/courses/30/lessons/42746
private class `42746` {
    fun solution(numbers: IntArray): String {
        val sb = StringBuilder()
        var onlyZero = true
        val list = numbers.sortedWith { o1, o2 ->
            if (o1 != 0 || o2 != 0) onlyZero = false
            val s1 = o1.toString() + o2.toString()
            val s2 = o2.toString() + o1.toString()
            s2.toInt() - s1.toInt()
        }

        if (onlyZero)
            return "0"

        list.forEach { sb.append(it) }
        return sb.toString()
    }
}
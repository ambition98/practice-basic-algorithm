package programmers.level2

//https://school.programmers.co.kr/learn/courses/30/lessons/12951
private class `12951` {
    fun solution(s: String): String {
        val sb = StringBuilder()
        var first = true

        s.forEach {
            if (first){
                sb.append(it.uppercase())
                first = false
            } else {
                sb.append(it.lowercase())
            }

            if (it == ' ')
                first = true
        }

        return sb.toString()
    }
}
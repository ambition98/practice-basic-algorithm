package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/12926
private class `12926` {
    fun solution(s: String, n: Int): String {
        val sb = StringBuilder()
        s.forEach {
            var c = it
            if (it in 'a'..'z') {
                c = 'a' + ((it - 'a' + n) % 26)
            } else if (it in 'A'..'Z') {
                c = 'A' + ((it -'A' + n) % 26)
            }

            sb.append(c)
        }

        return sb.toString()
    }
}
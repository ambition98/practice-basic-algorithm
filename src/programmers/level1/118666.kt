package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/118666
private class `118666` {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val res = arrayOf("RT", "CF", "JM", "AN")
        val map = mutableMapOf(
            'R' to 0, 'T' to 0,
            'C' to 0, 'F' to 0,
            'J' to 0, 'M' to 0,
            'A' to 0, 'N' to 0,
        )

        for (i in survey.indices) {
            if (choices[i] in 1..3) {
                map[survey[i][0]] = map.getValue(survey[i][0]) + (4 - choices[i])
            } else if (choices[i] in 5..7) {
                map[survey[i][1]] = map.getValue(survey[i][1]) + (choices[i] - 4)
            }
        }

        return res.map {  s ->
            s.toList().sortedWith(compareByDescending<Char> { map[it] }.thenBy { it })[0]
        }.joinToString("")
    }
}
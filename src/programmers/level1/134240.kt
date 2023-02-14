package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/134240
private class `134240` {
    fun solution(food: IntArray): String {
        val sb = StringBuilder()
        for (i in 1..food.lastIndex) {
            var food = food[i]
            while (food / 2 > 0) {
                sb.append(i)
                food -= 2
            }
        }
        val s = sb.toString()
        return "${s}0${sb.reverse()}"
    }
}
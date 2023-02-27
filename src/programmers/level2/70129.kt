package programmers.level2

/*
    문자열 N진수를 10진수로 변환
    "1111".toInt(2) //1111을 2진수로 읽어서 10진수 Int 형으로 변환
    "1111".toInt(8) //1111을 8진수로 읽어서 10진수 Int 형으로 변환
    "1111".toInt(16) //1111을 16진수로 읽어서 10진수 Int 형으로 변환
    * "12".toInt(2) //2진수에 2는 표현 불가능하므로 NumberFormatException

    Int 형 10진수를 N진수 문자열로 변환 (
    Integer.toBinaryString(10) //10을 2진수로 변환 -> 1010
    Integer.toOctalString(10) //10을 8진수로 변환 -> 11
    Integer.toHexString(10) //10을 2진수로 변환 -> 10
 */
//https://school.programmers.co.kr/learn/courses/30/lessons/70129
private class `70129` {
    fun solution(s: String): IntArray {
        var str = s
        var cntZero = 0
        var step = 0
        while (str != "1") {
            step++
            val cnt = str.count { it == '0' }
            val temp = str.replace("0", "").length
            str = Integer.toBinaryString(temp)
            cntZero += cnt
        }

        return intArrayOf(step, cntZero)
    }
}
package programmers.level1

import kotlin.math.abs

//https://school.programmers.co.kr/learn/courses/30/lessons/67256
private class `67256` {
    fun solution(numbers: IntArray, hand: String): String {
        val sb = StringBuilder()
        val map = mapOf(
            1 to "00", 2 to "01", 3 to "02",
            4 to "10", 5 to "11", 6 to "12",
            7 to "20", 8 to "21", 9 to "22",
            0 to "31"
        )
        var left = "30"
        var right = "32"

        numbers.forEach {
            when (it) {
                1, 4, 7 -> {
                    sb.append('L')
                    left = map[it]!!
                }
                3, 6, 9 -> {
                    sb.append('R')
                    right = map[it]!!
                }
                else -> {
                    val lgap = abs(map[it]!![0].digitToInt() - left[0].digitToInt()) + abs(map[it]!![1].digitToInt() -
                            left[1].digitToInt())
                    val rgap = abs(map[it]!![0].digitToInt() - right[0].digitToInt()) + abs(map[it]!![1].digitToInt() -
                            right[1].digitToInt())

                    if (lgap < rgap) {
                        sb.append('L')
                        left = map[it]!!
                    } else if (lgap > rgap) {
                        sb.append('R')
                        right = map[it]!!
                    } else {
                        if (hand == "left") {
                            sb.append('L')
                            left = map[it]!!
                        } else {
                            sb.append('R')
                            right = map[it]!!
                        }
                    }
                }
            }
        }

        return sb.toString()
    }
}
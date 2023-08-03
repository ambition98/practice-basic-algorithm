package programmers.level2

import kotlin.math.min

private class `77485` {

    class Solution {
        fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
            val res = IntArray(queries.size)
            var idx = 0
            var cnt = 1
            val arr = Array<IntArray>(rows) { IntArray(columns) { cnt++ } }

            // arr.forEach { println(it.joinToString(" ")) }
            queries.forEach {
                var x = it[0] - 1
                var y = it[1] - 1
                var min = 10001
                var temp = -1
                var prev = arr[x][y]
                val x1 = it[0]
                val y1 = it[1]
                val x2 = it[2]
                val y2 = it[3]
                var right = true
                var down = true
                var left = true
                var up = true

                while (right || down || left || up) {
                    min = min(min, prev)
                    if (right) {
                        if (y + 1 < y2) {
                            temp = arr[x][y+1]
                            arr[x][y+1] = prev
                            prev = temp
                            y++
                        } else {
                            right = false
                        }
                    } else if (down) {
                        if (x + 1 < x2) {
                            temp = arr[x+1][y]
                            arr[x+1][y] = prev
                            prev = temp
                            x++
                        } else {
                            down = false
                        }
                    } else if (left) {
                        if (y - 1 >= y1 - 1) {
                            temp = arr[x][y-1]
                            arr[x][y-1] = prev
                            prev = temp
                            y--
                        } else {
                            left = false
                        }
                    } else if (up) {
                        if (x - 1 >= x1 - 1) {
                            temp = arr[x-1][y]
                            arr[x-1][y] = prev
                            prev = temp
                            x--
                        } else {
                            up = false
                        }
                    }
                }
                res[idx++] = min
                println("min: $min")
            }

            return res
        }
    }
}

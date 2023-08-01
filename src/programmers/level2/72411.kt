package programmers.level2

private class `72411` {
    class Solution {
        fun solution(orders: Array<String>, course: IntArray): Array<String> {
            val map = mutableMapOf<String, Int>()
            val maxOfCourse = mutableMapOf<Int ,Int>()
            val res = mutableListOf<String>()

            orders.forEach { s ->
                for (i in 2..s.length) {
                    combi(s.toCharArray().sorted().joinToString(""), i).forEach {
                        map[it] = map.getOrDefault(it, 0) + 1
                    }
                }
            }

            course.forEach { i ->
                map.forEach {
                    if (i == it.key.length) {
                        val prev = maxOfCourse.getOrDefault(i, 0)
                        if (it.value > prev) maxOfCourse[i] = it.value
                    }
                }
            }

            maxOfCourse.forEach { max ->
                map.forEach {
                    if (it.value > 1 && it.key.length == max.key && it.value == max.value)
                        res.add(it.key)
                }
            }

            return res.sorted().toTypedArray()
        }

        fun combi(s: String, r: Int, d: Int = 0, start: Int = 0,
                  visited: BooleanArray = BooleanArray(s.length),
                  res: MutableList<String> = mutableListOf(),
                  sb: StringBuilder = StringBuilder()): List<String> {

            if (d == r) {
                res.add(sb.toString())
                return res
            }

            for (i in start until s.length) {
                if (!visited[i]) {
                    visited[i] = true
                    sb.append(s[i])
                    combi(s, r, d+1, i+1, visited, res, sb)
                    sb.deleteAt(sb.lastIndex)
                    visited[i] = false
                }
            }

            return res
        }
    }
}
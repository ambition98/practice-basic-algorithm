package programmers.level2

private class `131127` {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val map = HashMap<String, Int>()
        var cnt = 0
        for (i in want.indices) {
            map[want[i]] = number[i]
        }

        for (i in discount.indices) {
            val tempMap = map.toMutableMap()
            for (j in i..i + 9) {
                if (j !in discount.indices) break

                val product = discount[j]
                if (tempMap.contains(product)) {
                    tempMap[product] = tempMap[product]!! - 1
                }
            }

            cnt += if (tempMap.count { it.value != 0 } > 0) 0 else 1
        }

        return cnt
    }
}
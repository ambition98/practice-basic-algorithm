package programmers.level2

private class `92341` {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carMap = HashMap<String, Int>() // carNum: Entering minute
        val result = HashMap<String, Int>() // carNum: useMin

        records.forEach {
            val sp = it.split(" ")
            val m = sp[0].substring(0..1).toInt() * 60 + sp[0].substring(3..4).toInt()
            val carNum = sp[1]
            val state = sp[2]

            if (state == "IN") {
                carMap[carNum] = m
            } else {
                result[carNum] = m - carMap[carNum]!! + result.getOrDefault(carNum, 0)
                carMap.remove(carNum)
            }
        }

        carMap.forEach { k, v ->
            result[k] = (23 * 60 + 59) - v + result.getOrDefault(k, 0)
        }

        result.forEach { k, v ->
            println("$k: $v")
        }

        return result.toList()
            .sortedWith(compareBy{it.first})
            .map{ getFee(fees, it.second) }
            .toIntArray()
    }

    fun getFee(fees: IntArray, m: Int): Int {
        val useMin = m - fees[0]
        var unitTime = useMin / fees[2]
        return when {
            (useMin < 1) -> return fees[1]
            (useMin < fees[2] || useMin % fees[2] != 0) -> {
                (unitTime + 1) * fees[3] + fees[1]
            }
            else -> {
                unitTime * fees[3] + fees[1]
            }

        }
    }
}
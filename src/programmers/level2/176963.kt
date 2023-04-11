package programmers.level2

private class `176963` {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val map = mutableMapOf<String, Int>()
        val res = ArrayList<Int>()
        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }

        photo.forEach { arr ->
            var sum = 0
            arr.forEach {
                sum += map.getOrDefault(it, 0)
            }
            res.add(sum)
        }

        return res.toIntArray()
    }
}
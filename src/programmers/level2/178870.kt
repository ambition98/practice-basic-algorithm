package programmers.level2

private class `178870` {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val arr = mutableListOf<Pair<Int, Int>>()
        var end = 0
        var sum = 0

        for (i in sequence.indices) {
            while (end < sequence.size && sum < k) {
                sum += sequence[end++]
            }

            if (sum == k) arr.add(Pair(i, end-1))
            sum -= sequence[i]
        }

        arr.sortWith(compareBy({ it.second - it.first }, { it.first }))

        return intArrayOf(arr[0].first, arr[0].second)
    }
}
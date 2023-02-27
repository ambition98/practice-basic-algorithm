package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/42889
fun solution(N: Int, stages: IntArray): IntArray {
    val res = IntArray(N) { it }
    val failure = ArrayList<Pair<Int, Double>>()
    val map = HashMap<Int, Int>()
    var reached = 0

    stages.forEach {
        if (map.contains(it))
            map[it] = map.getValue(it) + 1
        else
            map[it] = 1
    }

    (N + 1 downTo 1).forEach {
        val n = map[it]!!
        reached += n
        if (it != N + 1) {
            if (reached == 0)
                failure.add(Pair(it, 0.0))
            else
                failure.add(Pair(it, n / reached.toDouble()))
        }
    }

    failure.sortedWith(compareByDescending<Pair<Int, Double>> { it.second }
        .thenBy { it.first })
        .forEachIndexed { index, pair ->

            res[index] = pair.first
        }

    return res

}

private class `42889` {
}
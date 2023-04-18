package programmers.level2

import kotlin.math.max

private class `87946` {
    lateinit var visited: BooleanArray
    lateinit var permList: ArrayList<IntArray>

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = BooleanArray(dungeons.size)
        permList = ArrayList<IntArray>(dungeons.size)
        permutation(dungeons.size, ArrayList<Int>())

        var max = 0
        var cnt = 0
        var current = k
        permList.forEach { arr ->
            arr.forEach {
                if (dungeons[it][0] <= current) {
                    if (dungeons[it][1] <= current) {
                        current -= dungeons[it][1]
                        cnt++
                    }
                }
            }
            max = max(max, cnt)
            current = k
            cnt = 0
        }

        return max
    }

    fun permutation(r: Int, temp: ArrayList<Int>) {
        if (temp.size == r) {
            permList.add(temp.toIntArray())
            return
        }

        for (i in 0 until r) {
            if (!visited[i]) {
                visited[i] = true
                temp.add(i)
                permutation(r, temp)
                temp.removeLast()
                visited[i] = false
            }
        }
    }
}
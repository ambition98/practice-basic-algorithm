package programmers.level2

private class `68936` {
    fun solution(arr: Array<IntArray>) = dfs(arr)

    fun dfs(arr: Array<IntArray>, d: Int = 0,
            s1: Int = 0, e1: Int = arr.lastIndex,
            s2: Int = 0, e2: Int = arr.lastIndex
    ): IntArray {
        val list = mutableListOf<IntArray>()
        val mid1 = (s1 + e1) / 2
        val mid2 = (s2 + e2) / 2
        val prev = arr[s1][s2]
        var isPossible = true
        // println("p1($s1, $e1), p2($s2, $e2), mid1: $mid1, mid2: $mid2")

        for (i in s1..e1) {
            for (j in s2..e2) {
                if (arr[i][j] != prev) {
                    isPossible = false
                    break
                }
            }
        }

        if (isPossible || mid1 < s1 || mid2 < s2) {
            return if (prev == 0) intArrayOf(1, 0) else intArrayOf(0, 1)
        }

        // println("devide")
        list.add(dfs(arr, d+1, s1, mid1, s2, mid2)) //좌상
        list.add(dfs(arr, d+1, s1, mid1, mid2+1, e2)) //우상
        list.add(dfs(arr, d+1, mid1+1, e1, s2, mid2)) //좌하
        list.add(dfs(arr, d+1, mid1+1, e1, mid2+1, e2)) //우하

        var zero = 0
        var one = 0
        list.forEach {
            zero += it[0]
            one += it[1]
        }
        // println("return. zero: $zero, one: $one")

        return intArrayOf(zero, one)
    }
}
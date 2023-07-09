package programmers.level2

private class `68645` {
    fun solution(n: Int): IntArray {
        val arr = Array(n) { IntArray(n) }
        val limit = (1..n).sum()
        val res = IntArray(limit)
        var up = false
        var down = true
        var right = false
        var p = Pair(0, 0)

        repeat(limit) {
            arr[p.first][p.second] = it + 1
            if (down) {
                if (p.first + 1 < n && arr[p.first + 1][p.second] == 0) {
                    p = Pair(p.first + 1, p.second)
                } else {
                    down = false
                    right = true
                    p = Pair(p.first, p.second + 1)
                }
            } else if (right) {
                if (p.second + 1 < n && arr[p.first][p.second + 1] == 0) {
                    p = Pair(p.first, p.second + 1)
                } else {
                    right = false
                    up = true
                    p = Pair(p.first - 1, p.second - 1)
                }
            } else {
                if (p.first - 1 >= 0 && p.second - 1 >= 0 && arr[p.first - 1][p.second - 1] == 0) {
                    p = Pair(p.first - 1, p.second - 1)
                } else {
                    up = false
                    down = true
                    p = Pair(p.first + 1, p.second)
                }
            }
        }

        var idx = 0
        arr.forEach { intArr ->
            intArr.forEach {
                if (it != 0) res[idx++] = it
            }
        }

        return res
    }
}
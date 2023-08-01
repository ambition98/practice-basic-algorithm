package programmers.level2

private class `154540` {
    class Solution {
        val mx = intArrayOf(-1, 0, 1, 0)
        val my = intArrayOf(0, 1, 0, -1)

        fun solution(maps: Array<String>): IntArray {
            val visited = Array(maps.size) { BooleanArray(maps[0].length) }
            val res = mutableListOf<Int>()

            for (i in maps.indices) {
                for (j in maps[0].indices) {
                    if (!visited[i][j] && maps[i][j] != 'X') {
                        res.add(dfs(i, j, maps, visited))
                    }
                }
            }

            return if (res.size > 0) res.sorted().toIntArray() else intArrayOf(-1)
        }

        fun dfs(x: Int, y: Int, arr: Array<String>,
                visited: Array<BooleanArray>): Int {

            visited[x][y] = true
            var sum = arr[x][y] - '0'
            for (i in mx.indices) {
                val nx = x + mx[i]
                val ny = y + my[i]
                if (nx in arr.indices && ny in arr[0].indices
                    && !visited[nx][ny] && arr[nx][ny] != 'X') {
                    sum += dfs(nx, ny, arr, visited)
                }
            }

            return sum
        }
    }
}
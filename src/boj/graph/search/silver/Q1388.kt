package boj.graph.search.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private val rowX = arrayOf(0, 0)
private val rowY = arrayOf(1, -1)
private val colX = arrayOf(-1, 1)
private val colY = arrayOf(0, 0)
private lateinit var visited: Array<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    visited = Array(n) { BooleanArray(m) }
    val list = ArrayList<String>(n)

    repeat(n) {
        list.add(br.readLine())
    }

    var cnt = 0
    repeat(n) {i ->
        repeat(m) {j ->
            if (!visited[i][j]) {
                dfs(list, Pair(i, j), list[i][j])
                cnt++
            }
        }
    }

    print(cnt)
}

fun dfs(list: ArrayList<String>, p: Pair<Int, Int>, prev: Char) {

    for (i in 0..1) {
        var nx = p.first
        var ny = p.second

        if (prev == '-') {
            nx += rowX[i]
            ny += rowY[i]
        } else {
            nx += colX[i]
            ny += colY[i]
        }

        if (isValidPos(list, Pair(nx, ny)) && list[nx][ny] == prev) {

            visited[nx][ny] = true
            dfs(list, Pair(nx, ny), prev)
        }
    }
}

fun isValidPos(list: ArrayList<String>, p: Pair<Int, Int>): Boolean {
    return p.first in list.indices && p.second in list[0].indices
            && !visited[p.first][p.second]
}
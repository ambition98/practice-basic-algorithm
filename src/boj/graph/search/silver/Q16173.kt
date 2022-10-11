package boj.graph.search.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

private lateinit var arr: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private val mx = arrayOf(0, 1) //우, 하
private val my = arrayOf(1, 0)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    arr = Array(n) { IntArray(n) }
    visited = Array(n) { BooleanArray(n) }
    repeat(n) {i ->
        val st = StringTokenizer(br.readLine())
        repeat(n) {j ->
            arr[i][j] = st.nextToken().toInt()
        }
    }

    br.close()

    if (bfs())
        print("HaruHaru")
    else
        print("Hing")
}

fun bfs(): Boolean {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val p = queue.poll()

        if (arr[p.first][p.second] == -1)
            return true

        for (i in mx.indices) {
            val nx = p.first + mx[i] * arr[p.first][p.second]
            val ny = p.second + my[i] * arr[p.first][p.second]

            if (nx in arr.indices && ny in arr[0].indices && !visited[nx][ny]) {
                visited[p.first][p.second] = true
                queue.offer(Pair(nx, ny))
            }
        }
    }

    return false
}
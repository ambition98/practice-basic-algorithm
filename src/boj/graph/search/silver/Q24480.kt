package boj.graph.search.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

private lateinit var visited: BooleanArray
private lateinit var orderArr: IntArray
private var order = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val sb = StringBuilder()
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val graph = Array(n + 1) { ArrayList<Int>() }
    visited = BooleanArray(n + 1)
    orderArr = IntArray(n + 1) { 0 }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val v1 = st.nextToken().toInt()
        val v2 = st.nextToken().toInt()
        graph[v1].add(v2)
        graph[v2].add(v1)
    }

    graph.forEach {
        if (it.isEmpty())
            return@forEach
        it.sortDescending()
    }

    dfs(graph, r)
    for (i in 1 until orderArr.size) {
        sb.append(orderArr[i]).append("\n")
    }
    print(sb)
}

fun dfs(graph: Array<ArrayList<Int>>, v: Int) {
    visited[v] = true
    orderArr[v] = ++order

    for (i in graph[v]) {
        if (!visited[i]) {
            dfs(graph, i)
        }
    }
}
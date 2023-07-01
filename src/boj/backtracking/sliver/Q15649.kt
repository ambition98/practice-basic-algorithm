package boj.backtracking.sliver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private class Q15649 {
    val sb = StringBuilder()
    lateinit var arr: IntArray
    lateinit var visited: BooleanArray

    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        visited = BooleanArray(n)
        arr = IntArray(m)
        permutaion(n, m, 0)
        print(sb)
    }

    fun permutaion(n: Int, m: Int, depth: Int) {
        if (depth == m) {
            arr.forEach { sb.append(it).append(" ") }
            sb.append("\n")
            return
        }

        for (i in 0 until n) {
            if (visited[i])
                continue
            visited[i] = true
            arr[depth] = i + 1
            permutaion(n, m, depth + 1)
            visited[i] = false
        }
    }
}

package boj.prefixsum.silver

import java.io.InputStreamReader
import java.io.BufferedReader
import java.util.StringTokenizer

private class `11659` {
    fun main () {
        val sb = StringBuilder()
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val arr = IntArray(n+1)
        st = StringTokenizer(br.readLine())

        for (i in 1..arr.lastIndex) {
            arr[i] = arr[i-1] + st.nextToken().toInt()
        }

        repeat(m) {
            st = StringTokenizer(br.readLine())
            val i = st.nextToken().toInt()
            val j = st.nextToken().toInt()
            sb.append("${arr[j] - arr[i-1]}\n")
        }

        println(sb.toString())
        br.close()
    }
}
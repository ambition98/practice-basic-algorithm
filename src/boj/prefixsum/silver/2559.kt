package boj.prefixsum.silver

import java.io.InputStreamReader
import java.io.BufferedReader
import kotlin.math.max

private class `2559` {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        val list = br.readLine().split(" ").map { it.toInt() }
        var res = 0
        var sum = 0

        for (i in 0 until k) {
            sum += list[i]
        }
        res = sum

        for (i in k..list.lastIndex) {
            sum -= list[i-k]
            sum += list[i]
            res = max(res, sum)
        }

        br.close()
        println(res)
    }
}
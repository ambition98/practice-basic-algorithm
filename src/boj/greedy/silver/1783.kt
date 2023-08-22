package boj.greedy.silver

import java.io.InputStreamReader
import java.io.BufferedReader
import kotlin.math.min

private class `1783` {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        if (n == 1) println(1)
        else if (n == 2) println(min(4, (m-1) / 2 + 1))
        else if (m < 7) println(min(4, m))
        else println(5 + m - 7)
    }
}
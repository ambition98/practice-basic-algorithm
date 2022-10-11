package boj.bruteforcing.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val arr = Array(n) { CharArray(m) }

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until m) {
            arr[i][j] = input[j]
        }
    }

    var x = 0
    var y = 0
    var cnt = 64
    while (x + 7 < n) {
        cnt = minOf(cnt, getWrongCnt(arr, x, y, 'W'), getWrongCnt(arr, x, y, 'B'))
        val next = getNextPos(x, y, m)
        x = next.first
        y = next.second
    }

    print(cnt)
}

fun getWrongCnt(arr: Array<CharArray>, x: Int, y: Int, startChar: Char): Int {
    var cnt = 0
    var c = startChar
    for (i in x until x + 8) {
        for (j in y until y + 8) {
            if (arr[i][j] != c)
                cnt++
            c = toggle(c)
        }
        c = toggle(c)
    }

    return cnt
}

fun getNextPos(x: Int, y: Int, m: Int): Pair<Int, Int> {
    return if (y + 8 < m)
        Pair(x, y + 1)
    else
        Pair(x + 1, 0)
}

fun toggle(c: Char): Char {
    return if (c == 'W') 'B' else 'W'
}
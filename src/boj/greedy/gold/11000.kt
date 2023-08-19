package boj.greedy.gold

import java.io.InputStreamReader
import java.io.BufferedReader
import java.util.PriorityQueue

private class `11000` {
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val pq = PriorityQueue<Int>()
        val n = br.readLine().toInt()
        val list = mutableListOf<Pair<Int, Int>>()
        repeat(n) {
            val (s, t) = br.readLine().split(" ").map { it.toInt() }
            list.add(s to t)
        }

        list.sortBy { it.first }
        for (p in list) {
            pq.offer(p.second)
            if (pq.isNotEmpty()) {
                if (pq.peek() <= p.first)
                    pq.poll()
            }
        }

        println(pq.size)
    }
}
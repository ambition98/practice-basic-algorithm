package programmers.level1

import java.util.*

//https://school.programmers.co.kr/learn/courses/30/lessons/138477
private class `138477` {
    fun solution(k: Int, score: IntArray): IntArray {
        val res = IntArray(score.size)
        val honer = LinkedList<Int>()
        var idx = 0
        score.forEach {
            insert(honer, it, k)
            res[idx++] = honer.last
        }

        return res
    }

    fun insert(honer: LinkedList<Int>, n: Int, k: Int) {
        if (honer.size < k) {
            if (honer.size == 0) {
                honer.add(n)
            } else {
                for (i in honer.indices) {
                    if (honer[i] < n) {
                        honer.add(i, n)
                        return
                    }
                }
                honer.add(n)
            }
            return
        }

        for (i in honer.indices) {
            if (honer[i] < n) {
                honer.add(i, n)
                honer.removeLast()
                break
            }
        }
    }
}
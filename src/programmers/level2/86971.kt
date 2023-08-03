package programmers.level2

import kotlin.math.abs
import kotlin.math.min

private class `86971` {
    class Solution {
        fun solution(n: Int, wires: Array<IntArray>): Int {
            var res = 101
            val tree = mutableMapOf<Int, MutableList<Int>>()
            wires.forEach {
                if (it[0] !in tree) tree[it[0]] = mutableListOf<Int>()
                if (it[1] !in tree) tree[it[1]] = mutableListOf<Int>()
                tree[it[0]]?.add(it[1])
                tree[it[1]]?.add(it[0])
            }

            wires.forEach {
                tree[it[0]]?.remove(it[1])
                tree[it[1]]?.remove(it[0])
                // println("${getCnt(it[0], tree)}, ${getCnt(it[1], tree)}")
                res = min(res, abs(getCnt(it[0], tree) - getCnt(it[1], tree)))
                tree[it[0]]?.add(it[1])
                tree[it[1]]?.add(it[0])
            }

            return res
        }

        fun getCnt(n: Int, tree: MutableMap<Int, MutableList<Int>>,
                   visit: MutableSet<Int> = mutableSetOf()): Int {

            var cnt = 0
            if (n in tree && n !in visit) {
                cnt++
                visit.add(n)
                tree[n]?.forEach { cnt += getCnt(it, tree, visit) }
            }

            return cnt
        }
    }
}
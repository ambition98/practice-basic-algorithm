package programmers.level2

import java.util.LinkedList

private class `42587` {
    fun solution(priorities: IntArray, location: Int): Int {
        var cnt = 0
        val queue = LinkedList<Pair<Int, Int>>() //Priority, Initial index
        val map = HashMap<Int, Int>()
        priorities.groupBy { it }.forEach { (key, arr) ->
            map[key] = arr.size
        }
        val keys = map.keys

        priorities.forEachIndexed { idx, n ->
            queue.offer(Pair(n, idx))
        }

        do {
            cnt++
            while (true) {
                var isHigher = true
                val current = queue.peekFirst()
                keys.forEach {
                    if (it > current.first) {
                        isHigher = false
                        return@forEach
                    }
                }
                if (isHigher)
                    break
                queue.offerLast(queue.pollFirst())
            }
            val p = queue.pollFirst()
            map[p.first] = map[p.first]!! - 1
            if (map[p.first]!! < 1)
                keys.remove(p.first)

        } while (p.second != location)

        return cnt
    }
}
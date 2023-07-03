package programmers.level2

import kotlin.math.sqrt

private class `42839` {
    lateinit var visited: BooleanArray
    var res = 0
    fun solution(numbers: String): Int {
        val primeSet = mutableSetOf<Int>()
        val arr = numbers.toCharArray().sortedByDescending { it }
        val max = arr.joinToString("").toInt()
        visited = BooleanArray(arr.size)

        for (i in 2..max) {
            val sqrt = sqrt(i.toDouble()).toInt()
            var isPrime = true
            for (j in 2..sqrt) {
                if (i % j == 0) {
                    isPrime = false
                    break
                }
            }

            if (isPrime) primeSet.add(i)
        }

        permutation(arr, primeSet)

        return res
    }

    fun permutation(arr: List<Char>, set: MutableSet<Int>,
                    sb: StringBuilder = StringBuilder()) {
        if (sb.isNotEmpty()) {
            val n = sb.toString().toInt()
            if (set.contains(n)) {
                set.remove(n)
                res++
            }
        }

        if (sb.length >= arr.size) return

        for (i in arr.indices) {
            if (!visited[i]) {
                visited[i] = true
                sb.append(arr[i])
                permutation(arr, set, sb)
                sb.deleteAt(sb.lastIndex)
                visited[i] = false
            }
        }
    }
}
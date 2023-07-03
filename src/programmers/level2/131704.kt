package programmers.level2

import java.util.Stack

private class `131704` {
    fun solution(order: IntArray): Int {
        val stack = Stack<Int>()
        val arr = IntArray(order.size) { it + 1 }
        var res = 0
        var orderIdx = 0
        var lineIdx = 0
        while (orderIdx in order.indices && lineIdx in arr.indices) {
            if (order[orderIdx] == arr[lineIdx]) {
                // println("바로 트럭에 적재: ${order[orderIdx]}")
                res++
                orderIdx++
                lineIdx++
            } else if (stack.isNotEmpty() && stack.peek() == order[orderIdx]) {
                // println("보조에서 꺼내어 트럭에 적재: ${stack.peek()}")
                stack.pop()
                // println(stack)
                orderIdx++
                res++
            } else {
                // println("보조에 보관")
                stack.push(arr[lineIdx++])
                // println(stack)
            }
        }

        while (stack.isNotEmpty()) {
            if (stack.peek() == order[orderIdx]) {
                stack.pop()
                res++
                orderIdx++
            } else {
                break
            }
        }

        return res
    }
}
package programmers.level2

import java.util.Stack

private class `60058` {
    class Solution {
        fun solution(p: String): String {
            if (isCorrect(p)) return p

            val split = sp(p)
            return recursive(split.first, split.second)
        }

        fun recursive(u: String, v: String): String {
            println("u: $u, v: $v")
            // if (v.length < 1) return "()"
            if (u.length < 1) return ""
            val split = sp(v)

            if (isCorrect(u)) {
                return u + recursive(split.first, split.second)

            } else {
                val sb = StringBuilder()
                for (i in 1 until u.lastIndex) {
                    if (u[i] == '(') sb.append(')')
                    else sb.append('(')
                }

                return "(" + recursive(split.first, split.second) + ")" + sb.toString()
            }
        }

        fun sp(s: String): Pair<String, String> {
            var cnt1 = 0
            var cnt2 = 0
            for (i in 0 until s.lastIndex) {
                if (s[i] == '(') cnt1++
                else if (s[i] == ')') cnt2++

                if (cnt1 == cnt2) {
                    return Pair(s.substring(0..i), s.substring(i+1..s.lastIndex))
                }

            }

            return Pair(s, "")
        }

        fun isCorrect(s: String): Boolean {
            val stack = Stack<Char>()
            s.forEach {
                if (it == '(') {
                    stack.push('(')
                } else {
                    if (stack.isEmpty()) return false
                    else stack.pop()
                }
            }

            return if (stack.isNotEmpty()) false else true
        }
    }
}
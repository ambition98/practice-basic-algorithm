package programmers.level2

private class `77885` {
    class Solution {
        fun solution(numbers: LongArray): LongArray {
            val res = LongArray(numbers.size)
            var idx = 0

            for (i in numbers) {
                if (i % 2 == 0L) {
                    res[idx++] = i + 1
                    continue
                }

                val arr = ("0" + i.toString(2)).toCharArray()
                for (j in arr.lastIndex downTo 0) {
                    if (arr[j] == '0') {
                        arr[j] = '1'
                        arr[j + 1] = '0'
                        res[idx++] = arr.joinToString("").toLong(2)
                        break
                    }
                }
            }

            return res
        }
    }
}
package programmers.level2

private class `43165` {
    fun solution(numbers: IntArray, target: Int) = combi(numbers, target)

    fun combi(arr: IntArray, target: Int, acc: Int = 0, idx: Int = 0): Int {
        if (idx == arr.size) {
            return if (acc == target) 1 else 0
        }

        var res = 0
        res += combi(arr, target, acc + arr[idx], idx + 1)
        res += combi(arr, target, acc + arr[idx] * -1, idx + 1)

        return res
    }
}
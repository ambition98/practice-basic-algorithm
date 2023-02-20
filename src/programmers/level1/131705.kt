package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/131705
private class `131705` {
    fun solution(number: IntArray): Int {
        var res = 0
        for (i in 0 until number.size - 2) {
            for (j in i+1 until number.size - 1) {
                for (k in j+1 until number.size) {
                    if (number[i] + number[j] + number[k] == 0)
                        res++
                }
            }
        }

        return res
    }

//fun combination(arr: IntArray, start: Int, depth: Int, resArr:IntArray): Int {
//    var res = 0
//    if (depth == 3) {
//        return if (resArr.sum() == 0) 1 else 0
//    }
//
//    for (i in start until arr.size) {
//        visit[i] = true
//        resArr[depth] = arr[i]
//        res += combination(arr, i + 1, depth + 1, resArr)
//        visit[i] = false
//    }
//
//    return res
//}
}
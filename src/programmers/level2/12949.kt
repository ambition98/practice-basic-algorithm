package programmers.level2

//https://school.programmers.co.kr/learn/courses/30/lessons/12949

/*
    행렬의 곱
    m행 k열 * k행 n열
    첫 번째 행렬의 i 행과, 두 번째 행의 j 열의
    각 원소끼리의 곱의 합이
    결과 행렬의 (i, j)

    * 행렬의 곱이 가능하려면 k는 같아야 한다다
*/
private class `12949` {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>)
    = Array(arr1.size) { i ->
        IntArray(arr2[0].size) { j ->
            val temp = IntArray(arr2.size) { arr2[it][j] }
            sum(arr1[i], temp)
        }
    }

    fun sum(arr1: IntArray, arr2: IntArray): Int {
        var sum = 0
        for (i in arr1.indices) {
            sum += arr1[i] * arr2[i]
        }
        return sum
    }
}
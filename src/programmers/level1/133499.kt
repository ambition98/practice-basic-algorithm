package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/133499
/*
    정규표현식을 만들기 힘들다면
    표현식을 두 개를 나누어서 매치 시도하는 것을 생각하자
 */
private class `133499` {
    fun solution(babbling: Array<String>) =
        babbling.count { "(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+".toRegex().matches(it) }

//fun solution(babbling: Array<String>) =
//    babbling.count {
//      !"(ayaaya|yeye|woowoo|mama)+".toRegex().containsMatchIn(it) &&
//      "(aya|ye|woo|ma)+".toRegex().matches(it)
//    }

}
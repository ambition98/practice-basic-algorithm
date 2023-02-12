package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/147355
private class `147355` {
    /*
    Kotlin 문자열 비교
    Kotlin 에서 >, < ... 등으로 비교를 시도하면
    내부적으로 String.compareTo() 메서드가 호출된다. s1 < s2, s1.compareTo(s2)

    String.compareTo()
    기본적으로 index 0 부터 아스키값 비교를 시도한다.
    "aaa".compareTo("abc") // index 0은 같으므로 continue, index 1은 a가 작으므로 -1 리턴
    "abc".compareTo("ac") // index 0은 같으므로 continue, index 1은 a가 더 작으므로 -1 리턴

    문자열 길이가 다르면 비교할 수 있는 데 까지 비교 후,
    문자열이 동일하여 비교불가능하면 길이의 차이를 리턴한다.
    "aaa".compareTo("aa") // index 1 까지 비교하였으나 같으므로 길이의 차이인 3-2 = 1 리턴
 */
    fun solution(t: String, p: String): Int {
        var res = 0
        var right = p.length - 1

        while(right < t.length) {
            val s = t.substring(right - (p.length - 1) ..right)
            if (t >= s)
                res++
            right++
        }

        return res
    }
}
package programmers.level1

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//https://school.programmers.co.kr/learn/courses/30/lessons/150370
private class `150370` {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val list = ArrayList<Int>()
        val map = HashMap<Char, Int>()
        terms.forEach {
            val sp = it.split(" ")
            map[sp[0][0]] = sp[1].toInt()
        }

        privacies.forEachIndexed { i, s ->
            val sp = s.split(" ")
            val m: Int = map[sp[1][0]]!!
            val expiry = convertDate(sp[0], m)
            if (isExpired(today, expiry)) list.add(i + 1)
        }

        return list.toIntArray()
    }

    fun isExpired(today: String, date: String): Boolean {
        val sp1 = today.split(".")
        val sp2 = date.split(".")
        val t1 = Date(sp1[0].toInt(), sp1[1].toInt(), sp1[2].toInt()).time
        val t2 = Date(sp2[0].toInt(), sp2[1].toInt(), sp2[2].toInt()).time
        return t1 >= t2
    }

    fun convertDate(date: String, month: Int): String {
        val sp = date.split(".")
        var y = sp[0].toInt()
        var m = sp[1].toInt() + month

        y += m / 12
        m %= 12

        return "$y.$m.${sp[2]}"
    }
}
package programmers.level2

private class `42888` {
    fun solution(record: Array<String>): Array<String> {
        val userMap = HashMap<String, String>() // uid: nickname
        val res = ArrayList<String>()
        record.forEach {
            val sp = it.split(" ")
            when (sp[0]) {
                "Enter", "Change" -> userMap[sp[1]] = sp[2]
            }
        }

        record.forEach {
            val sp = it.split(" ")
            when (sp[0]) {
                "Enter" -> res.add("${userMap[sp[1]]}님이 들어왔습니다.")
                "Leave" -> res.add("${userMap[sp[1]]}님이 나갔습니다.")
                else -> {}
            }
        }

        return res.toTypedArray()
    }
}
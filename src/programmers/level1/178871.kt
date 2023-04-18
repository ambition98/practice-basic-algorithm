package programmers.level1

private class `178871` {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val map = HashMap<String, Int>()
        players.forEachIndexed { idx, player ->
            map[player] = idx
        }

        callings.forEach {
            val idx =  map[it]!!
            val p = players[idx - 1]
            players[idx] = players[idx - 1]
            players[idx - 1] = it
            map[it] = map[it]!! - 1
            map[p] = map[p]!! + 1
        }

        return players
    }
}
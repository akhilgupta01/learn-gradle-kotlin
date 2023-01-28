package org.tech20.aoc22

import java.io.File

enum class Strategy{
    FIRST, SECOND
}

class RockPaperScissorsPlayer(val filePath:String, val strategy: Strategy = Strategy.FIRST){
    private val winningPairs = setOf(Pair("Rock", "Paper"), Pair("Paper", "Scissors"), Pair("Scissors", "Rock"))
    private val drawPairs = setOf(Pair("Rock", "Rock"), Pair("Paper", "Paper"), Pair("Scissors", "Scissors"))
    private val loosingPairs = setOf(Pair("Paper","Rock"), Pair("Scissors","Paper"), Pair("Rock","Scissors"))
    private val movesMap = mapOf("A" to "Rock","B" to "Paper", "C" to "Scissors", "X" to "Rock","Y" to "Paper", "Z" to "Scissors")
    private val pointsMap = mapOf("Rock" to 1, "Paper" to 2, "Scissors" to 3)

    private fun calculateMove(moveOpponentSymbol:String, str:String): Pair<String, String>{
        val moveOpponent = requireNotNull(movesMap[moveOpponentSymbol])
        return if(Strategy.SECOND == strategy) {
            when (str) {
                "X" -> loosingPairs.first { x -> x.first == moveOpponent }
                "Y" -> drawPairs.first { x -> x.first == moveOpponent }
                else -> winningPairs.first { x -> x.first == moveOpponent }
            }
        }else{
            Pair(moveOpponent, requireNotNull(movesMap[str]))
        }
    }
    private fun score(move: Pair<String, String>):Int{
        return if (winningPairs.contains(move)) 6
        else if (drawPairs.contains(move)) 3
        else 0
    }
    fun calculateScore():Int{
        val scores = mutableListOf<Int>()
        File(ClassLoader.getSystemResource("day2.txt").file).forEachLine {
            val moveTokens = it.split(" ")
            val move = calculateMove(moveTokens[0], moveTokens[1])
            val movePoint = pointsMap[move.second] ?: 0
            scores.add(score(move) + movePoint)
        }
        return scores.sum()
    }
}
fun main(){
    println(RockPaperScissorsPlayer("day2.txt", Strategy.FIRST).calculateScore())
    println(RockPaperScissorsPlayer("day2.txt", Strategy.SECOND).calculateScore())
}
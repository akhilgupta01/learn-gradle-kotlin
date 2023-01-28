package org.tech20.challenges.string

object StringChallenges{
    private fun capitalizeWord(word:String):String = word.replaceFirstChar { it.uppercaseChar() }
    fun capitalize(str: String): String{
        return str.split(" ")
            .joinToString(" "){ capitalizeWord(it) }
    }

    fun getIndex(strList: List<String>, str: String): Int{
        strList.forEachIndexed { index, s -> if(s == str) return index }
        return -1
    }

    fun formatTrainRoute(stationList: List<String>):String {
        var res = ""
        stationList.forEach {
            res += when(it){
                stationList.first() -> it
                stationList.last() -> " and $it"
                else -> ", $it"
            }
        }
        return "Train is calling at $res"
    }
}

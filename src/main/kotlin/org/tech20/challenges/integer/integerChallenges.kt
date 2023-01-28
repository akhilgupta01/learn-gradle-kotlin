package org.tech20.challenges.integer

object IntegerChallenges{
    fun findOddNumbers(numbers: List<Int>): List<Int>{
        return numbers.filter { it % 2 != 0 }
    }

    /**
     * Checks if the second ranges is contained within in the first range
     * */
    fun containsRange(range1: IntRange, range2: IntRange): Boolean {
        return range2.first >= range1.first && range2.last <= range1.last
    }

    /**
     * For a given number n, returns the sum of all the numbers from 1 to n
     * */
    fun addUpTo(n: Int): Int{
        val numbers = mutableListOf<Int>()
        for (i in 1..n){
            numbers.add(i)
        }
        return numbers.sum()
    }

    /**
     * For a given number n, returns a list of all numbers from n to 0
     * */
    fun countDown(n:Int):List<Int>{
        val list = mutableListOf<Int>()
        for (i in n downTo 0){
            list.add(i)
        }
        return list
    }

    /**
     * For a given number n, returns a list of all numbers from 0 to n and then from n-1 to 0
     * */
    fun countUpAndDown(n:Int):List<Int>{
        return (0 until n).toList() + (n downTo 0).toList()
    }

    /**
     * Generates all possibles pairs that can be made using numbers between 0 to n
     * */
    fun generateAllPairs(n: Int): List<Pair<Int, Int>> {
        val pairs = mutableListOf<Pair<Int, Int>>()
        for (i in 0..n)
            for (j in 0..n){
                pairs.add(Pair(i,j))
            }
        return pairs
    }

    /**
     * Returns the count of unique numbers in a given array
    * */
    fun countUniqueValues(values: Array<Int>): Int {
        return values.toSet().size
    }
}

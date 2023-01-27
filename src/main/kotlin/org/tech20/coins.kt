package org.tech20

fun main() {
//    val nums = emptyList<Int>()
//    println(nums.drop(4))
    getCoins(4, listOf(1, 2, 3)).forEach {
        println(it)
    }
}

fun getCoins(amount:Int, denominations:List<Int>): List<List<Int>>{
    val denoms = denominations.sortedDescending()
    val combinations = mutableListOf<List<Int>>()
    if(denoms.size == 1 && amount % denoms.first() == 0){
        val subList = mutableListOf<Int>()
        repeat(amount / denoms.first()){subList.add(denoms.first())}
        combinations.add(subList)
        return combinations
    }else if(denoms.size == 1){
        return emptyList()
    }
    val max = amount / denoms.first()
    for(i in 0..max) {
        val subList = mutableListOf<Int>()
        repeat(i) { subList.add(denoms.first()) }
        getCoins(amount-subList.sum(), denoms.drop(1)).forEach{
            combinations.add(subList + it)
        }
    }
    return combinations
}
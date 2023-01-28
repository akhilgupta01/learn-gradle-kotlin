package org.tech20.aoc22

import java.io.File

class CalorieCounter(){
    fun sumOfTopNEnergies(fileName: String, n: Int): Int{
        var currentEnergy = 0
        val energies = mutableSetOf<Int>()
        File(ClassLoader.getSystemResource(fileName).file).forEachLine {
            if(it.isNotEmpty()){
                currentEnergy += Integer.parseInt(it)
            }else{
                energies.add(currentEnergy)
                currentEnergy = 0
            }
        }
        return energies.sortedDescending().slice(0 until n).sum()
    }
}
fun main(){
    println(CalorieCounter().sumOfTopNEnergies("day1.txt", 1))
    println(CalorieCounter().sumOfTopNEnergies("day1.txt", 3))
}
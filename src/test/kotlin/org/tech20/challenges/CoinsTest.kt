package org.tech20.challenges

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

private class CoinsTest {
    @Test
    fun shouldReturnCorrectCoinCombinations() {
        val expectedCombinations = listOf(
            listOf(1,1,1,1),
            listOf(2,1,1),
            listOf(3,1),
            listOf(2,2)
        )
        val generatedCombinations = Coins.getCoins(4, listOf(1,2,3))
        assertTrue(generatedCombinations.containsAll(expectedCombinations))
    }
}
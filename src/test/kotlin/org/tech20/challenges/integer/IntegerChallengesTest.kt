package org.tech20.challenges.integer

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.tech20.challenges.integer.IntegerChallenges.addUpTo
import org.tech20.challenges.integer.IntegerChallenges.containsRange
import org.tech20.challenges.integer.IntegerChallenges.countDown
import org.tech20.challenges.integer.IntegerChallenges.countUniqueValues
import org.tech20.challenges.integer.IntegerChallenges.countUpAndDown
import org.tech20.challenges.integer.IntegerChallenges.generateAllPairs
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

private class IntegerChallengesTest{

    @Test
    fun returnsOddNumbers(){
        val oddNumbers = IntegerChallenges.findOddNumbers(listOf(3,5,6,1))
        Assertions.assertEquals(listOf(3,5,1), oddNumbers)
    }

    @Test
    fun determinesRanges(){
        assertTrue(containsRange(5..7, 5..7))
        assertTrue(containsRange(1..12, 5..7))
        assertFalse(containsRange(5..8, 5..9))
    }

    @Test
    fun testAddUpTo(){
        assertEquals(6, addUpTo(3))
        assertEquals(1, addUpTo(1))
    }

    @Test
    fun testCountDown(){
        assertEquals(listOf(4,3,2,1,0), countDown(4))
    }

    @Test
    fun testCountUpAndDown(){
        assertEquals(listOf(0,1,2,1,0), countUpAndDown(2))
    }

    @Test
    fun testGenerateAllPairs(){
        val expectedPairs = listOf(Pair(0,1),Pair(0,0),Pair(1,1), Pair(1,0))
        val generatedPairs = generateAllPairs(1)
        assertTrue(generatedPairs.containsAll(expectedPairs))
        assertTrue(expectedPairs.containsAll(generatedPairs))
    }

    @Test
    fun testUniqueNumbers(){
        countUniqueValues(arrayOf(-2, -1, -1, 0, 1)) shouldBeEqualTo  4
    }
}
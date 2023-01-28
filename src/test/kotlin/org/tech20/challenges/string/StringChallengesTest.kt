package org.tech20.challenges.string

import kotlin.test.Test
import org.amshove.kluent.shouldBeEqualTo
import org.tech20.challenges.string.StringChallenges.formatTrainRoute
import org.tech20.challenges.string.StringChallenges.getIndex

private class StringChallengesTest {
    @Test
    fun `"flower" is capitalized to "Flower"`() {
        StringChallenges.capitalize("flower") shouldBeEqualTo "Flower"
    }

    @Test
    fun `"this is a house" is capitalised to "This Is A House"`() {
        StringChallenges.capitalize("this is a house") shouldBeEqualTo "This Is A House"
    }

    @Test
    fun `index of "C" in ("A", "B", "C") is 2`() {
        getIndex(listOf("A", "B", "C"), "C") shouldBeEqualTo 2
    }

    @Test
    fun `index of "D" in ("A", "B", "C") is -1`() {
        getIndex(listOf("A", "B", "C"), "D") shouldBeEqualTo -1
    }

    @Test
    fun `"Luton" should be returned as "Train is calling at Luton"`(){
        formatTrainRoute(listOf("Luton")) shouldBeEqualTo "Train is calling at Luton"
        formatTrainRoute(listOf("Luton", "Harpenden")) shouldBeEqualTo "Train is calling at Luton and Harpenden"
        formatTrainRoute(listOf("Luton", "Harpenden", "London")) shouldBeEqualTo "Train is calling at Luton, Harpenden and London"
    }
}
package MastermindGameTest

import MastermindGame.*
import MastermindGame.PegImplColourMock
import MastermindGame.PegImplResultMock
import MastermindGame.PegListGuessMock
import org.junit.Before

import org.junit.Test
import kotlin.test.assertEquals

class GameHistoryTests {
    val gameHistory = GameHistoryImpl

    @Test
    fun checkStartsAtZero() {
        assertEquals(0, gameHistory.getProgress())
    }

    @Test
    fun addOneWorks() {
        gameHistory.addGuess()
        assertEquals(1, gameHistory.getProgress())
    }

    @Test
    fun stopsAt12() {
        for (i in 1..11) gameHistory.addGuess()
        assertEquals(12, gameHistory.getProgress())
    }
}
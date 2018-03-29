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
        assertEquals(gameHistory.getProgress(), 0)
    }
}
package MastermindGameTest

import MastermindGame.*
import MastermindGame.PegImplColourMock
import MastermindGame.PegImplResultMock
import MastermindGame.PegListGuessMock

import org.junit.Test
import kotlin.test.assertEquals

class GuessCheckerMockTests {

    val greenPeg = PegImplColourMock("G")
    val secondGreen = PegImplColourMock("G")
    val thirdGreen = PegImplColourMock("G")
    val bluePeg = PegImplColourMock("B")
    val yellowPeg = PegImplColourMock("Y")
    val secondYellow = PegImplColourMock("Y")
    val thirdYellow = PegImplColourMock("Y")
    val fourthYellow = PegImplColourMock("Y")
    val redPeg = PegImplColourMock("R")
    val whitePeg = PegImplResultMock("W")
    val secondWhite = PegImplResultMock("W")
    val thirdWhite = PegImplResultMock("W")
    val fourthWhite = PegImplResultMock("W")
    val blackPeg = PegImplResultMock("B")
    val secondBlack = PegImplResultMock("B")
    val thirdBlack = PegImplResultMock("B")
    val fourthBlack = PegImplResultMock("B")
    val blankPeg = PegImplResultMock("_")
    val secondBlank = PegImplResultMock("_")
    val thirdBlank = PegImplResultMock("_")
    val fourthBlank = PegImplResultMock("_")
    val secretCodeMock = PegListGuessMock(mutableListOf(greenPeg, bluePeg, secondGreen, redPeg))
    val guessChecker = GuessCheckerImpl(secretCodeMock)

    @Test
    fun sameCodeAllBlack() {
        guessChecker.setGuess(secretCodeMock)
        val allBlackPegList = PegListResultsMock(listOf(blackPeg, secondBlack, thirdBlack, fourthBlack))
        assertEquals(allBlackPegList.toString(), guessChecker.generateResult().toString())
    }

    @Test
    fun noPegsAllBlank() {
        val allBlankPegList = PegListResultsMock(listOf(blankPeg, secondBlank, thirdBlank, fourthBlank))
        guessChecker.setGuess(PegListGuessMock(mutableListOf(yellowPeg, secondYellow, thirdYellow, fourthYellow)))
        assertEquals(allBlankPegList.toString(), guessChecker.generateResult().toString())
    }

    @Test
    fun onePegWrong() {
        val onePegWrongList = PegListResultsMock(listOf(blackPeg, secondBlack, thirdBlack, whitePeg))
        guessChecker.setGuess(PegListGuessMock(mutableListOf(greenPeg, bluePeg, secondGreen, thirdGreen)))
        assertEquals(onePegWrongList.toString(), guessChecker.generateResult().toString())
    }

    @Test
    fun twoPegsWrong() {
        val twoPegWrongList = PegListResultsMock(listOf(blackPeg, secondBlack, blankPeg, secondWhite))
        guessChecker.setGuess(PegListGuessMock(mutableListOf(greenPeg, bluePeg, yellowPeg, secondGreen)))
        assertEquals(twoPegWrongList.toString(), guessChecker.generateResult().toString())
    }

    @Test
    fun allPegsDifferent() {
        val allPegsDifferent = PegListGuessMock(mutableListOf(greenPeg, yellowPeg, redPeg, bluePeg))
        val allPegsDifferentOrder = PegListGuessMock(mutableListOf(bluePeg, redPeg, yellowPeg, greenPeg))
        val differentGuessChecker = GuessCheckerImpl(allPegsDifferent)
        differentGuessChecker.setGuess(allPegsDifferentOrder)
        assertEquals(PegListResultsMock(listOf(whitePeg, secondWhite, thirdWhite, fourthWhite)).toString(), differentGuessChecker.generateResult().toString())
    }
}
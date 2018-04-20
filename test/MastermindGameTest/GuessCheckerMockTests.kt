package MastermindGameTest

import MastermindGame.*
import MastermindGame.Colours.*

import org.junit.Test
import kotlin.test.assertEquals

class GuessCheckerMockTests {

    val greenPeg = PegImpl(Gcolour)
    val bluePeg = PegImpl(Bcolour)
    val yellowPeg = PegImpl(Ycolour)
    val redPeg = PegImpl(Rcolour)

    val blackPeg = PegImpl(ResultColourBlack)
    val whitePeg = PegImpl(ResultColourWhite)
    val blankPeg = PegImpl(ResultNoColour)

    val secretCodeMock = PegListImpl(mutableListOf(greenPeg, bluePeg, greenPeg, redPeg))
    val guessChecker = GuessCheckerImpl(secretCodeMock)

    @Test
    fun sameCodeAllBlack() {
        guessChecker.setGuess(secretCodeMock)
        assertEquals(listOf(ResultColourBlack, ResultColourBlack, ResultColourBlack, ResultColourBlack), guessChecker.generateResult())
    }

    @Test
    fun noPegsAllBlank() {
        guessChecker.setGuess(PegListImpl(mutableListOf(yellowPeg, yellowPeg, yellowPeg, yellowPeg)))
        assertEquals(listOf(ResultNoColour, ResultNoColour, ResultNoColour, ResultNoColour), guessChecker.generateResult())
    }

    @Test
    fun onePegWrong() {
        guessChecker.setGuess(PegListImpl(mutableListOf(greenPeg, bluePeg, greenPeg, yellowPeg)))
        assertEquals(listOf(ResultColourBlack, ResultColourBlack, ResultColourBlack, ResultNoColour), guessChecker.generateResult())
    }

    @Test
    fun twoPegsWrong() {
        guessChecker.setGuess(PegListImpl(mutableListOf(greenPeg, bluePeg, yellowPeg, greenPeg)))
        assertEquals(listOf(ResultColourBlack, ResultColourBlack, ResultNoColour, ResultColourWhite), guessChecker.generateResult())
    }

    @Test
    fun allPegsDifferent() {
        val allPegsDifferent = PegListImpl(mutableListOf(greenPeg, yellowPeg, redPeg, bluePeg))
        val allPegsDifferentOrder = PegListImpl(mutableListOf(bluePeg, redPeg, yellowPeg, greenPeg))
        val differentGuessChecker = GuessCheckerImpl(allPegsDifferent)
        differentGuessChecker.setGuess(allPegsDifferentOrder)
        assertEquals(listOf(ResultColourWhite, ResultColourWhite, ResultColourWhite, ResultColourWhite), differentGuessChecker.generateResult())
    }

    @Test
    fun duplicatesGetEqualNumberOfWhitePegs() {
        val duplicateCode = PegListImpl(mutableListOf(greenPeg, greenPeg, bluePeg, bluePeg))
        val duplicateGuessChecker = GuessCheckerImpl(duplicateCode)
        val duplicateGuess = PegListImpl(mutableListOf(greenPeg, greenPeg, greenPeg, bluePeg))
        duplicateGuessChecker.setGuess(duplicateGuess)
        assertEquals(listOf(ResultColourBlack, ResultColourBlack, ResultNoColour, ResultColourBlack), duplicateGuessChecker.generateResult())
    }

    @Test
    fun reproducingError() {
        val wrongGuessChecker = GuessCheckerImpl(PegListImpl(mutableListOf(redPeg, yellowPeg, bluePeg, redPeg)))
        val firstGuess = PegListImpl(mutableListOf(redPeg, redPeg, redPeg, redPeg))
        wrongGuessChecker.setGuess(firstGuess)
        assertEquals(listOf(ResultColourBlack, ResultNoColour, ResultNoColour, ResultColourBlack), wrongGuessChecker.generateResult())
    }

    @Test
    fun reproducingError2() {
        val wrongGuessChecker2 = GuessCheckerImpl(PegListImpl(mutableListOf(redPeg, yellowPeg, bluePeg, redPeg)))
        val firstGuess2 = PegListImpl(mutableListOf(redPeg, redPeg, yellowPeg, redPeg))
        wrongGuessChecker2.setGuess(firstGuess2)
        assertEquals(listOf(ResultColourBlack, ResultNoColour, ResultColourWhite, ResultColourBlack), wrongGuessChecker2.generateResult())
    }

    @Test
    fun reproducingError3() {
        val wrongGuessChecker3 = GuessCheckerImpl(PegListImpl(mutableListOf(redPeg, yellowPeg, bluePeg, redPeg)))
        val firstGuess3 = PegListImpl(mutableListOf(yellowPeg, yellowPeg, yellowPeg, redPeg))
        wrongGuessChecker3.setGuess(firstGuess3)
        assertEquals(listOf(ResultNoColour, ResultColourBlack, ResultNoColour, ResultColourBlack), wrongGuessChecker3.generateResult())
        val secondGuess3 = PegListImpl(mutableListOf(yellowPeg, greenPeg, yellowPeg, redPeg))
        wrongGuessChecker3.setGuess(secondGuess3)
        assertEquals(listOf(ResultColourWhite, ResultNoColour, ResultNoColour, ResultColourBlack), wrongGuessChecker3.generateResult())
    }

    @Test
    fun reproducingError4() {
        val wrongGuessChecker4 = GuessCheckerImpl(PegListImpl(mutableListOf(redPeg, yellowPeg, bluePeg, redPeg)))
        val secondGuess3 = PegListImpl(mutableListOf(yellowPeg, greenPeg, yellowPeg, redPeg))
        wrongGuessChecker4.setGuess(secondGuess3)
        assertEquals(listOf(ResultColourWhite, ResultNoColour, ResultNoColour, ResultColourBlack), wrongGuessChecker4.generateResult())
    }
}
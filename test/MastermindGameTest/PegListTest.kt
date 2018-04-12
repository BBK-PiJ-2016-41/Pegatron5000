package MastermindGameTest

import MastermindGame.Colours.*
import MastermindGame.Peg
import MastermindGame.PegImpl
import MastermindGame.PegList
import MastermindGame.PegListImpl
import kotlin.test.assertEquals
import org.junit.Test
import org.junit.Before

class PegListTest {

    lateinit var mapOfColourPegs: PegList
    lateinit var mapOfResultPegs: PegList
    lateinit var mapOfPegsEmpty: PegList
    lateinit var pegOne: Peg
    lateinit var pegTwo: Peg
    lateinit var pegThree: Peg
    lateinit var pegFour: Peg
    lateinit var pegBlack: Peg
    lateinit var pegWhite: Peg
    lateinit var pegNoColour: Peg

    @Before
    fun setUp() {
        pegOne = PegImpl(Bcolour)
        pegTwo = PegImpl(Ocolour)
        pegThree = PegImpl(Gcolour)
        pegFour = PegImpl(Gcolour)
        pegBlack = PegImpl(ResultColourBlack)
        pegWhite = PegImpl(ResultColourWhite)
        pegNoColour = PegImpl(ResultNoColour)
        val listOfColourPegs = mutableListOf(pegOne, pegTwo, pegThree, pegFour)
        val listOfResultsPegs = mutableListOf(pegBlack, pegWhite, pegNoColour, pegWhite)
        val emptyListOfPegs = mutableListOf<Peg>()
        mapOfColourPegs = PegListImpl(listOfColourPegs)
        mapOfResultPegs = PegListImpl(listOfResultsPegs)
        mapOfPegsEmpty = PegListImpl(emptyListOfPegs)
    }

    // coloured pegs tests
    @Test
    fun testColouredPegAtIndexOne() {
        val expected = "B"
        val actual = mapOfColourPegs.getPegMap()[1].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testColouredPegAtIndexTwo() {
        val expected = "O"
        val actual = mapOfColourPegs.getPegMap()[2].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testColouredPegAtIndexThree() {
        val expected = "G"
        val actual = mapOfColourPegs.getPegMap()[3].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testColouredPegAtIndexFourSameColourAsThree() {
        val expected = "G"
        val actual = mapOfColourPegs.getPegMap()[4].toString()
        assertEquals(expected, actual)
    }

    @Test (expected = AssertionError::class)
    fun testColouredNonExistantIndex() {
        val expected = "P"
        val actual = mapOfColourPegs.getPegMap()[5].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testColouredToString() {
        val expected = "BOGG"
        val actual = mapOfColourPegs.toString()
        assertEquals(expected, actual)
    }

    //results pegs
    @Test
    fun testResultPegAtIndexOne() {
        val expected = "Black "
        val actual = mapOfResultPegs.getPegMap()[1].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testResultPegAtIndexTwo() {
        val expected = "White "
        val actual = mapOfResultPegs.getPegMap()[2].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testResultPegAtIndexThree() {
        val expected = ""
        val actual = mapOfResultPegs.getPegMap()[3].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testResultPegAtIndexFourSameColourAsTwo() {
        val expected = "White "
        val actual = mapOfResultPegs.getPegMap()[4].toString()
        assertEquals(expected, actual)
    }

    @Test (expected = AssertionError::class)
    fun testResultNonExistantIndex() {
        val expected = "Black "
        val actual = mapOfResultPegs.getPegMap()[5].toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testResultToString() {
        val expected = "Black White White "
        val actual = mapOfResultPegs.toString()
        assertEquals(expected, actual)
    }


    @Test
    fun testResultToStringNoPegs() {
        val expected = "No pegs"
        val actual = mapOfPegsEmpty.toString()
        assertEquals(expected, actual)
    }

}
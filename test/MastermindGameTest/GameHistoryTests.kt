//package MastermindGameTest
//
//import MastermindGame.*
//import org.junit.Before
//
//import org.junit.Test
//import kotlin.test.assertEquals
//
//class GameHistoryTests {
//    private lateinit var gameHistory: GameHistoryImpl
//
//    @Before
//    fun before() {
//        gameHistory = GameHistoryImpl
//    }
//
//    @Test
//    fun checkStartsAtZero() {
//        assertEquals(0, gameHistory.getProgress())
//    }
//
//    @Test
//    fun addOneWorks() {
//        gameHistory.addGuess()
//        assertEquals(1, gameHistory.getProgress())
//    }
//
//    @Test
//    fun wontCreateSecondInstance() {
//        gameHistory.addGuess()
//        val newHistory = GameHistoryImpl
//        assertEquals(1, newHistory.getProgress())
//    }
//
//}
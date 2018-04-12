package MastermindGameTest

import MastermindGame.Factory
import MastermindGame.Game
import MastermindGame.GameImpl
import org.junit.Test
import org.junit.Before
import kotlin.test.assertEquals

class GameTest {

    lateinit var gameTrue: Game
    lateinit var gameFalse: Game

    @Before
    fun setUp() {
        gameTrue = Factory.getInstance(GameImpl::class, true)
        //gameFalse = Factory.getInstance(GameImpl::class, false) use in displayTheCode tests
    }

    //getNumPegs
    //generateCode
    //getUserGuess
    //displayTheCode
    //printAvailableColours
    //updateAndPrintHistory
    //checkGuess
    //playAnotherGame

}
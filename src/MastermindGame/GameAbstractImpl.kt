package MastermindGame

import MastermindGame.Colours.Colour

/**
 * Create a Game object.
 *
 * @param showCode If showCode is true the secret code will be
 * revealed at all times when playing the game. If it is
 * false the secret code is not revealed until correctly guessed
 * or the player runs out of turns.
 */

abstract class GameAbstractImpl(private val showCode: Boolean) : Game {

    abstract override fun runGames()

}

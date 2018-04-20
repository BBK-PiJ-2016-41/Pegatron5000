package MastermindGame

import kotlin.reflect.KClass

object Factory {

    /**
     * creates an instance of a Mastermind game
     * @param c: the kotlin class for which an instance needs creating
     * @param b: boolean value indicating whether the game should display the secret code or not
     * @return an instance of GameImpl
     */
    fun getInstance(c: KClass<out Any>, b: Boolean?): GameImpl {

        return c.constructors.first().call(b) as GameImpl

    }


}
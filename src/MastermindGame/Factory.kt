package MastermindGame

import kotlin.reflect.KClass

object Factory {

    fun getInstance(c: KClass<out Any>, b: Boolean?): GameImpl {

        return c.constructors.first().call(b) as GameImpl

    }


}
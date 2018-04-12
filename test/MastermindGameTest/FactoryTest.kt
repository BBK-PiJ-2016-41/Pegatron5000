import MastermindGame.Factory
import MastermindGame.GameImpl
import MastermindGame.PegImpl
import org.junit.Test
import kotlin.test.assertEquals

class FactoryTest {

    @Test
    fun testGetInstanceFromFactoryCorrectTrue() {
        val expected = GameImpl(true)
        val actual = Factory.getInstance(GameImpl::class, true)
        assertEquals(expected::class, actual::class)
        assertEquals(expected.showCode, actual.showCode)
    }

    @Test
    fun testGetInstanceFromFactoryCorrectFalse() {
        val expected = GameImpl(false)
        val actual = Factory.getInstance(GameImpl::class, false)
        assertEquals(expected::class, actual::class)
        assertEquals(expected.showCode, actual.showCode)
    }

    @Test (expected = IllegalArgumentException::class)
    fun testGetInstanceFromFactoryNotCorrect() {
        val instance = Factory.getInstance(PegImpl::class, true)
    }


}
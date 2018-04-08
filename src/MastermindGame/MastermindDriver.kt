package MastermindGame

object MastermindDriver {

    // Example - change as you need to...
    @JvmStatic
    fun main(args: Array<String>) {
        var g = Factory.getInstance(GameImpl::class, true)
        g.runGames()

//        g = Factory.getInstance(GameImpl::class, false)
//        g.runGames()
    }
}
package MastermindGame

object MastermindDriver {

    /**
     * the main entry point into the Mastermind game
     */
    @JvmStatic
    fun main(args: Array<String>) {
        var g = Factory.getInstance(GameImpl::class, true)
        g.runGames()

//        g = Factory.getInstance(GameImpl::class, false)
//        g.runGames()
    }
}
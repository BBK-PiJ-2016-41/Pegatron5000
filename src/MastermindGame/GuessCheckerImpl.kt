package MastermindGame

class GuessCheckerImpl (val secretPegCode: PegList, var pegGuess: PegList): GuessChecker {

    fun generateResult(): PegList {
        return pegGuess
    }
}
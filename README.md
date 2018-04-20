# Pegatron5000
The Mastermind game for SDP CW3 - Go Team Win
<p>Ian Robinson / irobin02</p>
<p>Kathryn Buckley / kbuckl03</p>
<p>Sarah Vincent / svince04</p>
<p>Hannah Spencer / hspenc03</p>

<p>To-do</p>
<ul>
	<li>I think GuessValidator and GuessValidatorImpl can be deleted.  I created a GameImpl which didn't use it and i think PegFactory.interpretUserInput does what the GuessValidator does</li>
	<li>Should PegFactory have an interface? We have a mix of objects don't have interfaces and some that do</li>
	<li>Add summary of how to add colours, change amount of turns and select number of pegs to play with to ReadMe</li>
	<li>Add break down of areas worked on by each of us to the ReadMe</li>
	<li>Colour.kt requires docstring</li>
	<li>GameHistory.kt add docstring to clearHistory method</li>
	<li>GameHistoryImpl.kt remove docstrings from methods which already have them in interface</li>
	<li>GuessChecker.kt add docstring to isCorrect method</li>
	<li>GuessCheckerImpl.kt add docstring to pegResult, removePegColoursFromMaps.  Remove from isCorrect as it goes in the interface</li>
	<li>GuessValidatorImpl.kt replace peg with it in the return of checkGuess method</li>
	<li>GameTest unit tests need writing</li>
	<li>GameHistoryTest unit tests need updating</li>
	<li>GuessCheckerTest unit tests need updating</li>
	<li>GuessValidatorTest unit tests need updating</li>
</ul>

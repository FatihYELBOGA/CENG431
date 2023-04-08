package User;

import Quizzes.Quiz;
import Random.RandomGenerator;

public interface IUser {
	
	public boolean isValidQuizLimit(int limit);
	
	public boolean solveQuiz(Quiz quiz,RandomGenerator randomGenerator);

}

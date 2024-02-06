package com.telvad.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telvad.quizapp.dao.QuestionDao;
import com.telvad.quizapp.dao.QuizDao;
import com.telvad.quizapp.model.Question;
import com.telvad.quizapp.model.QuestionWrapper;
import com.telvad.quizapp.model.Quiz;
import com.telvad.quizapp.model.Response;

@Service
public class QuizService {
	
@Autowired
QuizDao dao;

@Autowired
QuestionDao quesDao;

public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
	List<Question> questions = quesDao.findQuestionsByCategory(category,numQ);
	
	Quiz quiz=new Quiz();
	quiz.setTitle(title);
	quiz.setQuestions(questions);
	dao.save(quiz);
	return new ResponseEntity<String>("success",HttpStatus.CREATED);
	
	
}

public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
	
	Optional<Quiz> quiz = dao.findById(id);
	List<Question> quesFromDB = quiz.get().getQuestions();
	List<QuestionWrapper> quesForUser = new ArrayList<>();
	for(Question q:quesFromDB)
	{
		QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
		quesForUser.add(qw);
	}
	return new ResponseEntity<List<QuestionWrapper>>(quesForUser,HttpStatus.OK);
	
}

public ResponseEntity<Integer> submitResponse(int id, List<Response> responses) {
	Quiz quiz= dao.findById(id).get();
	List<Question> ques = quiz.getQuestions();
	int score=0;
	for(int i=0;i<ques.size();i++)
	{
//		System.out.println(responses.get(i));
		if(responses.get(i).getResponse().equals(ques.get(i).getRightAnswer())) {
//			System.out.println("dasdas");
			score++;
		}
	}
	
	return new ResponseEntity<Integer>(score,HttpStatus.ACCEPTED);
}



}

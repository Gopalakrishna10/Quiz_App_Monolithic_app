package com.example.demo.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Model.Questions;
import com.example.demo.Model.Quiz;
import com.example.demo.Model.Responce;
import com.example.demo.Repo.QuestionRepo;
import com.example.demo.Repo.QuizRepo;
@Service
public class QuizServiceImp {
	@Autowired
	private QuizRepo quizRepo;
	@Autowired
	private QuestionRepo questions;
	
	public ResponseEntity<String> createQuiz(String category, String title) {
		List<Questions> question=questions.findByRamcategory(category);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		quizRepo.save(quiz);
		return new ResponseEntity<String>("success" ,HttpStatus.CREATED);
	}

	
	
	public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
		
		Optional<Quiz> quiz= quizRepo.findById(id);
		List<Questions> qFromDB =quiz.get().getQuestions();
		List<QuestionWrapper> QWrapper = new ArrayList<QuestionWrapper>();
		
		for(Questions q: qFromDB) {
			QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			QWrapper.add(qw);
		}
		return  new ResponseEntity<List<QuestionWrapper>>(QWrapper,HttpStatus.OK); 
	}



	public ResponseEntity<Integer>calculateReponce(Integer id, List<Responce> responce) {
		 Quiz quiz= quizRepo.findById(id).get();
		List<Questions> qFromDB =quiz.getQuestions();
		int right=0,i=0;
		
		for(Responce responces : responce) {
			if(responces.getResponce().equals(qFromDB.get(i).getRightanswer()))
				right++;
			
			i++;
		}
		
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}
	

}
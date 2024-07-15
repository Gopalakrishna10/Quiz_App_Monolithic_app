package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Model.Questions;
import com.example.demo.Model.Quiz;
import com.example.demo.Model.Responce;
import com.example.demo.ServiceImp.QuizServiceImp;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("quiz/")
public class QuizController {
	@Autowired	
	private QuizServiceImp  quizServiceImp;
	
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category ,@RequestParam String title){
		return quizServiceImp.createQuiz(category,title);
		
	}
	
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
		return quizServiceImp.getQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitResponce(@PathVariable Integer id ,@RequestBody List<Responce> responce){
	
		return quizServiceImp.calculateReponce(id,responce);
	}
	
	
	
	
}
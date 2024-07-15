package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Questions;

import com.example.demo.ServiceImp.QuestionServiceImp;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	private QuestionServiceImp questionService; 
	
	
	@GetMapping("get")
	public ResponseEntity< List<Questions>> getAllQuestions(){
		return questionService.getQuestions();
		
	}
	@GetMapping("category/{category}")
	public ResponseEntity< List<Questions>> getByCategory(@PathVariable String category){
		return questionService.getByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity< Questions > addQuestion( @RequestBody Questions question) {
		return questionService.addQuestion(question);
	}
	

}
package com.example.demo.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Questions;

import com.example.demo.Repo.QuestionRepo;


@Service
public class QuestionServiceImp  {
	@Autowired
	private  QuestionRepo questionRepo;
//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public QuestionsDTO addQuestion(QuestionsDTO questionDto) {
//		Questions question= this.modelMapper.map(questionDto, Questions.class);
//		
//		Questions addLoad=this.questionRepo.save(question);
//		return this.modelMapper.map(addLoad, QuestionsDTO.class);
//	}
//
//	@Override
//	public List<QuestionsDTO> getQuestions() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<QuestionsDTO> getByCategory(String category) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public ResponseEntity<List<Questions> >getQuestions() {
		return new ResponseEntity<List<Questions>>( questionRepo.findAll(),HttpStatus.OK);
		 
	}

	public ResponseEntity<List<Questions> >getByCategory(String category) {
		
		return new ResponseEntity<List<Questions>>( questionRepo.category(category),HttpStatus.OK);
	}

	public  ResponseEntity<Questions>   addQuestion(Questions question) {
		return new ResponseEntity<>( questionRepo.save(question),HttpStatus.CREATED);
		
	}
//	
	
}
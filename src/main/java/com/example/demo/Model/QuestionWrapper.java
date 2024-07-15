package com.example.demo.Model;

import java.util.Objects;

public class QuestionWrapper {

	private int id;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, option1, option2, option3, option4, question);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionWrapper other = (QuestionWrapper) obj;
		return id == other.id && Objects.equals(option1, other.option1) && Objects.equals(option2, other.option2)
				&& Objects.equals(option3, other.option3) && Objects.equals(option4, other.option4)
				&& Objects.equals(question, other.question);
	}
	@Override
	public String toString() {
		return "QuestionWrapper [id=" + id + ", question=" + question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + "]";
	}
	public QuestionWrapper(int id, String question, String option1, String option2, String option3, String option4) {
		super();
		this.id = id;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}
	public QuestionWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
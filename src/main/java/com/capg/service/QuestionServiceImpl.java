package com.capg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.capg.exception.QuestionNotFoundException;
import com.capg.model.Question;
import com.capg.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question addQuestion(Question ques) {
		Question q = questionRepository.save(ques);
		return q;
	}

	@Override
	public ResponseEntity<List<Question>> getQuestions() {
		List<Question> questions = questionRepository.findAll();
		return ResponseEntity.ok().body(questions);
	}

	@Override
	public ResponseEntity<Question> getQuestionById(int q_id) throws QuestionNotFoundException {
		Question question = questionRepository.findById(q_id)
				.orElseThrow(() -> new QuestionNotFoundException("Q_ID :: " + q_id + " Not Found"));
		return ResponseEntity.ok().body(question);
				
	}

}

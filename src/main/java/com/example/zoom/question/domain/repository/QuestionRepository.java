package com.example.zoom.question.domain.repository;

import com.example.zoom.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {


}

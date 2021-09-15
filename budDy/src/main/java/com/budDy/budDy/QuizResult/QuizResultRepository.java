package com.budDy.budDy.QuizResult;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizResultRepository
    extends JpaRepository<QuizResult, Long> {

        Optional<QuizResult> getQuizResultById(Long id);
}


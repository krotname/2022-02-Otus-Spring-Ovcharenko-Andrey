package ru.otus.work02.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.work02.dao.QuestionsDao;
import ru.otus.work02.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionsService {

    private final QuestionsDao dao;
    private final List<Integer> usesNumber = new ArrayList<>();

    public List<Question> getByName() {
        return dao.getQuestions();
    }

    public int getRandom() {
        int i;

        do {
            i = (int) (Math.random() * 5);
        }
        while (usesNumber.contains(i));

        usesNumber.add(i);
        return i;
    }

}

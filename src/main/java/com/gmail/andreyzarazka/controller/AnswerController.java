package com.gmail.andreyzarazka.controller;

import com.gmail.andreyzarazka.domain.Answer;
import com.gmail.andreyzarazka.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public String main() {
        return "main";
    }

    @PostMapping()
    public String add(@RequestParam(name = "dec", required = false, defaultValue = "0") int dec, Map<String, Object> model) {
        answerService.calculate(dec);

        Answer answer = answerService.getAnswer();

        model.put("answers", answer);

        return "main";
    }
}
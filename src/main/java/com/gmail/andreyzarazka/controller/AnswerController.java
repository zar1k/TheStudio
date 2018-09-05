package com.gmail.andreyzarazka.controller;

import com.gmail.andreyzarazka.domain.Answer;
import com.gmail.andreyzarazka.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    private final AnswerService service;

    public AnswerController(AnswerService service) {
        this.service = service;
    }

    @PostMapping("api/parse")
    public ResponseEntity<?> parse(@RequestBody int dec) {
        service.calculate(dec);

        Answer answer = service.getAnswer();

        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
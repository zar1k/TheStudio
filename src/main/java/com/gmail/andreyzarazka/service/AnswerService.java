package com.gmail.andreyzarazka.service;

import com.gmail.andreyzarazka.domain.Answer;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AnswerService {
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void calculate(int dex) {
        answer = null;

        String bin = Integer.toBinaryString(dex);
        int count = 0;
        StringBuilder sb = new StringBuilder();

        String pattern = "([0]+)1";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(bin);
        while (m.find()) {
            count++;
            int length = m.group(0).length() - 1;
            sb.append(length).append(" ");
        }
        answer = new Answer(bin, count, sb.toString().trim());
    }
}
package com.gmail.andreyzarazka.domain;

import java.util.Objects;

public class Answer {
    private String bin;
    private int intervalCount;
    private String intervalLength;

    public Answer(String bin, int intervalCount, String intervalLength) {
        this.bin = bin;
        this.intervalCount = intervalCount;
        this.intervalLength = intervalLength;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public int getIntervalCount() {
        return intervalCount;
    }

    public void setIntervalCount(int intervalCount) {
        this.intervalCount = intervalCount;
    }

    public String getIntervalLength() {
        return intervalLength;
    }

    public void setIntervalLength(String intervalLength) {
        this.intervalLength = intervalLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer = (Answer) o;
        return intervalCount == answer.intervalCount &&
                Objects.equals(bin, answer.bin) &&
                Objects.equals(intervalLength, answer.intervalLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bin, intervalCount, intervalLength);
    }
}

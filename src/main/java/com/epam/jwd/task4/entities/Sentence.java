package com.epam.jwd.task4.entities;

import java.util.List;

public class Sentence {
    private List<String> sentenceParts;
    private List<String> words;
    private List<String> punctuations;

    public List<String> getSentenceParts() {
        return sentenceParts;
    }

    public void setSentenceParts(List<String> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public void setPunctuations(List<String> punctuations) {
        this.punctuations = punctuations;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getPunctuations() {
        return punctuations;
    }
}
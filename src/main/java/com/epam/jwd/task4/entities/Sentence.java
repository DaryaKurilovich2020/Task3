package com.epam.jwd.task4.entities;

import java.util.List;

public class Sentence {
    private List<SentencePart> sentenceParts;
    private List<Word> words;
    private List<PunctuationMark> punctuations;
    public List<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

    public void setSentenceParts(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public Sentence() {
    }

    public List<Word> getWords() {
        return words;
    }

    public List<PunctuationMark> getPunctuations() {
        return punctuations;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void setPunctuations(List<PunctuationMark> punctuations) {
        this.punctuations = punctuations;
    }
}
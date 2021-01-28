package com.epam.jwd.task4.entities;

public class Word extends SentencePart{
    String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

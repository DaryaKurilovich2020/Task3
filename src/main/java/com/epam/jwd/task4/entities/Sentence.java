package com.epam.jwd.task4.entities;

import java.util.List;

public class Sentence {
    private List<SentencePart> sentenceParts;

    public List<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

    public void setSentenceParts(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public Sentence() {
    }
}

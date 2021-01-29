package com.epam.jwd.task4.parsers;

import com.epam.jwd.task4.entities.Sentence;
import com.epam.jwd.task4.properties.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {
    private String text;
    private static final Properties properties;

    static {
        properties = new Properties();
    }

    public SentenceParser(String text) {
        this.text = text;
    }

    public List<String> parseSentences() {
        List<String> sentences = new ArrayList<>();
        Matcher matcher= Pattern.compile("([^.!?]+[.!?])").matcher(text);
        while (matcher.find()){
            sentences.add(matcher.group());
        }
        return sentences;
    }

    private Sentence split(String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence, Properties.PUNCTUATIONS, true);
        List<String> sentenceParts = new ArrayList<>();
        List<String> words=new ArrayList<>();
        List<String> punctuationMarks=new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.matches(properties.PUNCTUATIONS)) {
                String newMark=token.trim();
                sentenceParts.add(newMark);
                punctuationMarks.add(newMark);
            } else {
                String newWord=token.trim();
                sentenceParts.add(newWord);
                words.add(newWord);
            }
        }
        Sentence newSentence=new Sentence();
        newSentence.setWords(words);
        newSentence.setPunctuations(punctuationMarks);
        newSentence.setSentenceParts(sentenceParts);
        return newSentence;
    }

    public List<Sentence> parse() {
        List<Sentence> sentences = new ArrayList<>();
        for (String sentence : parseSentences()) {
            Sentence newSentence = split(sentence);
            sentences.add(newSentence);
        }
        return sentences;
    }
}

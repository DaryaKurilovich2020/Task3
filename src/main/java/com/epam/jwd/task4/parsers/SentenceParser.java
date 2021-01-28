package com.epam.jwd.task4.parsers;

import com.epam.jwd.task4.entities.PunctuationMark;
import com.epam.jwd.task4.entities.Sentence;
import com.epam.jwd.task4.entities.SentencePart;
import com.epam.jwd.task4.entities.Word;
import com.epam.jwd.task4.properties.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {
    private String text;
    private Properties properties;

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

    private List<SentencePart> split(String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence, properties.PUNCTUATIONS, true);
        List<SentencePart> sentenceParts = new ArrayList<>();
        List<Word> words=new ArrayList<>();
        List<PunctuationMark> punctuationMarks=new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.matches(properties.PUNCTUATIONS)) {
                PunctuationMark newMark=new PunctuationMark(token.trim());
                sentenceParts.add(newMark);
                punctuationMarks.add(newMark);
            } else {
                Word newWord=new Word(token.trim());
                sentenceParts.add(newWord);
                words.add(newWord);
            }
        }
        return sentenceParts;
    }

    public List<Sentence> parse() {
        List<Sentence> sentences = new ArrayList<>();
        for (String sentence : parseSentences()) {
            Sentence newSentence = new Sentence();
            newSentence.setSentenceParts(split(sentence));
            sentences.add(newSentence);
        }
        return sentences;
    }
}

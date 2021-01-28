package com.epam.jwd.task4.textanalyzer;

import com.epam.jwd.task4.entities.Sentence;
import com.epam.jwd.task4.entities.Text;
import com.epam.jwd.task4.entities.Word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TextAnalyzer {
    private Text text;

    public TextAnalyzer(Text text) {
        this.text = text;
    }

    public Text swapFirstAndLastWords() {
        Text newText = text;
        for (int i = 0; i < newText.getSentences().size(); i++) {
            newText.getSentences().get(i).setWords(swap(newText.getSentences().get(i).getWords()));
        }
        return newText;
    }

    private List<Word> swap(List<Word> words) {
        if (!words.isEmpty()) {
            Word tmp = words.get(0);
            words.set(0, words.get(words.size() - 1));
            words.set(words.size() - 1, tmp);
        }
        return words;
    }

    public Text printByWordsAmountIncrease() {
        Text newText = new Text();
        List<Sentence> sentences = text.getSentences();
        sentences.sort(Comparator.comparingInt((Sentence s) -> s.getWords().size()));
        newText.setSentences(sentences);
        return newText;
    }

    public Text replaceWithSubstringByLength(int sentenceNumber, int length, String substring) {
        Text newText = text;
        Sentence sentence = text.getSentences().get(sentenceNumber - 1);
        if (sentence != null) {
            sentence.getWords().stream()
                    .filter(word -> word.getWord().length() == length)
                    .forEach(word -> word.setWord(substring));
        }
        return newText;
    }

    public HashMap<Word, Integer> findNumberOfOccurrences(List<String> words) {
        HashMap<Word, Integer> occurrences = new HashMap<>();
        List<Sentence> sentences = text.getSentences();
        int occurrenceNumber = 0;
        for (String word : words) {
            occurrenceNumber = 0;
            Word newWord = new Word(word);
            for (int i = 0; i < sentences.size(); i++) {
                for (Word word1 : sentences.get(i).getWords()) {
                    if (word1.equals(newWord)) {
                        occurrenceNumber++;
                    }
                }
            }
            occurrences.put(newWord, occurrenceNumber);
        }
        return occurrences;
    }

    public Text deleteSubstring(String firstWord, String lastWord) {
        Text newText = text;
        List<Sentence> sentences = newText.getSentences();
        for (int i = 0; i < sentences.size(); i++) {
            Sentence sentence = sentences.get(i);
            List<Word> words = sentence.getWords();
            List<Word> newWords = new ArrayList<>();
            if (words.contains(new Word(firstWord)) && words.contains(new Word(lastWord))) {
                int lastIndex = words.lastIndexOf(new Word(lastWord));
                int firstIndex = words.indexOf(new Word(firstWord));
                for (int j = 0; j < words.size(); j++) {
                    if (j < firstIndex) {
                        newWords.add(words.get(j));
                    }
                    if (j > lastIndex) {
                        newWords.add(words.get(j));
                    }
                }
            }
            sentence.setWords(newWords);
        }
        newText.setSentences(sentences);
        return newText;
    }
}

package com.epam.jwd.task4.textanalyzer;

import com.epam.jwd.task4.entities.Sentence;
import com.epam.jwd.task4.entities.Text;

import java.util.*;
import java.util.stream.Collectors;

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

    private List<String> swap(List<String> words) {
        if (!words.isEmpty()) {
            String tmp = words.get(0);
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
                    .filter(word -> word.length() == length)
                    .forEach(word -> word = substring);
        }
        return newText;
    }

    public HashMap<String, Integer> findNumberOfOccurrences(List<String> words) {
        HashMap<String, Integer> occurrences = new HashMap<>();
        List<Sentence> sentences = text.getSentences();
        int occurrenceNumber = 0;
        for (String word : words) {
            occurrenceNumber = 0;
            String newWord = word;
            for (Sentence sentence : sentences) {
                for (String word1 : sentence.getWords()) {
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
        for (Sentence sentence : sentences) {
            List<String> words = sentence.getWords();
            List<String> newWords = new ArrayList<>();
            if (words.contains(firstWord) && words.contains(lastWord)) {
                int lastIndex = words.lastIndexOf(lastWord);
                int firstIndex = words.indexOf(firstWord);
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

    public Set<String> getWordsByLengthInQuestions(int length) {
        Set<String> words = new HashSet<>();
        for (Sentence sentence : text.getSentences()) {
            List<String> punctuations = sentence.getPunctuations();
            if (punctuations.get(punctuations.size() - 1).equals("?")) {
                for (String word : sentence.getWords()) {
                    if (word.length() == length) {
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    public Text deleteByLengthAndStartingWithConsonant(int length) {
        Text newText = text;
        String vowels = "aeiouаоуыяюи";
        List<Character> vowelsList = vowels.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Sentence> sentences = newText.getSentences();
        for (Sentence sentence : sentences) {
            List<String> words = sentence.getWords();
            for (String word : words) {
                if (word.length() == length && vowelsList.contains(word.charAt(0))) {
                    words.remove(word);
                }
            }
        }
        return newText;
    }

}

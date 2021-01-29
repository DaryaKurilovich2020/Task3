package com.epam.jwd.task4.entities;

import java.io.Serializable;
import java.util.List;

public class Text implements Serializable {
    private List<CodeBlock> codeBlocks;
    private List<Sentence> sentences;

    public void addCodeBlock(CodeBlock codeBlock){
        codeBlocks.add(codeBlock);
    }
    public Text() {
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<CodeBlock> getCodeBlocks() {
        return codeBlocks;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
package com.epam.jwd.task4.parsers;

import com.epam.jwd.task4.entities.CodeBlock;
import com.epam.jwd.task4.entities.Sentence;
import com.epam.jwd.task4.entities.Text;
import com.epam.jwd.task4.properties.Properties;

import java.util.Arrays;
import java.util.List;

public class TextParser {
    List<String> lines;
    Properties properties;

    public TextParser(List<String> lines) {
        this.lines = lines;
    }

    public Text parse() {
        Text text = new Text();
        StringBuilder textPart = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.matches(properties.CODE_BLOCK_START)) {
                CodeBlock codeBlock = new CodeBlock();
                while (!line.matches(properties.CODE_BLOCK_END)) {
                    codeBlock.addLine(line);
                    i++;
                }
                text.addCodeBlock(codeBlock);
            } else {
                textPart.append(line);
            }
        }
        SentenceParser parser = new SentenceParser(textPart.toString());
        text.setSentences(parser.parse());
        return text;
    }
}

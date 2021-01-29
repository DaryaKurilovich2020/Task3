package com.epam.jwd.task4.entities;

import java.util.List;

public class CodeBlock {
    private List<String> lines;

    public CodeBlock() {
    }

    public void addLine(String line) {
        lines.add(line);
    }
}

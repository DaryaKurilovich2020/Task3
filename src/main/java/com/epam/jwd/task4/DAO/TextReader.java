package com.epam.jwd.task4.DAO;

import com.epam.jwd.task4.entities.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    private BufferedReader reader;
    private final String filename;

    public TextReader(String filename) {
        this.filename = filename;
    }

    public Text read() throws IOException {
        Text text = new Text();

        return text;
    }

    public List<String> readLines() throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}

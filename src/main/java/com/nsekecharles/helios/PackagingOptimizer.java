package com.nsekecharles.helios;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class PackagingOptimizer {
    public static final int boxSize = 10;

    public static String optimize(String articles) {

        char[] articlesNumber = articles.toCharArray();

        StringJoiner joiner = new StringJoiner("/");

        int currentSize = 0;
        StringBuilder boxContent = new StringBuilder();

        for (char c : articlesNumber) {
            int parsedArticlesNumber = Character.getNumericValue(c);
            if (currentSize + parsedArticlesNumber <= boxSize) {
                currentSize += parsedArticlesNumber;
                boxContent.append(parsedArticlesNumber);
            } else {
                joiner.add(boxContent);
                boxContent = new StringBuilder();
                boxContent.append(parsedArticlesNumber);
                currentSize = parsedArticlesNumber;
            }
        }

        joiner.add(boxContent);

        return joiner.toString();
    }
}

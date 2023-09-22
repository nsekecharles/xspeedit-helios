package com.nsekecharles.helios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PackagingOptimizer {
    public static final int boxSizeLimit = 10;

    public static String optimize(String articles) {

        char[] articlesNumber = articles.toCharArray();
        List<List<Integer>> boxesContent = new ArrayList<>();
        boxesContent.add(new ArrayList<>());

        for (char c : articlesNumber) {
            int parsedArticlesNumber = Character.getNumericValue(c);
            boolean added = false;
            for (List<Integer> box : boxesContent) {
                if (box.stream().reduce(0, Integer::sum) + parsedArticlesNumber <= boxSizeLimit) {
                    box.add(parsedArticlesNumber);
                    added = true;
                    break;
                }
            }
            if(!added) {
                List<Integer> box = new ArrayList<>();
                box.add(parsedArticlesNumber);
                boxesContent.add(box);
            }

        }

        return boxesContent.stream()
                .map(box-> box.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining()))
                .collect(Collectors.joining("/"));
    }
}

package com.twu.topsearch;

public class Search {
    private final String name;
    private int trending;

    public Search(String name) {
        this.name = name;
        this.trending = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getTrending() {
        return this.trending;
    }

    public void setTrending(int num) {
        this.trending += num;
    }
}

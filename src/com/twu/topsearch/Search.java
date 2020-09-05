package com.twu.topsearch;

/**
 * object: search item
 * field: name of the search item
 * field: trending of search item
 */
public class Search {
    private final String name;
    private int trending;

    public Search(String name) {
        this.name = name;
        this.trending = 0;
    }

    /**
     * get method
     * @return name of the search item
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return trending of the search item
     */
    public int getTrending() {
        return this.trending;
    }

    /**
     * vote tickets for search item
     * @param num number of tickets intend
     * to add to current search item
     */
    public void setTrending(int num) {
        this.trending += num;
    }
}

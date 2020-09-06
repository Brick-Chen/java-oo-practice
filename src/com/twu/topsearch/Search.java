package com.twu.topsearch;

/**
 * object: search item
 * field: name of the search item
 * field: trending of search item
 */
public class Search {
    private final String name;
    private int trending;
    private int rank;

    public Search(String name) {
        this.name = name;
        this.trending = 0;
        this.rank = 0;
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

    /**
     *
     * @return whether search item is purchased
     */
    public boolean isPaid() {
        return this.rank != 0;
    }

    /**
     * set ranking number
     * @param rank ranking number
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     *
     * @return ranking number
     */
    public int getRank() {
        return this.rank;
    }

    @Override
    public boolean equals(Object o) {
       if (!(o instanceof Search)) {
           return false;
       }
       Search anotherSearch = (Search) o;
       if (anotherSearch == this) {
           return true;
       }
       return this.name.equals(anotherSearch.getName());
    }
}

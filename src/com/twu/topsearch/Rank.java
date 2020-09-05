package com.twu.topsearch;

/**
 * class Rank: object to record the ranking
 * and search items bought by the users
 */
public class Rank {
    /**
     * ranking
     */
    private final int num;

    /**
     * current price paid for this ranking
     */
    private int price;

    /**
     * current search item name of this ranking
     */
    private String searchName;

    public Rank(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public int getPrice() {
        return this.price;
    }

    public void setSearchName(String newName) {
        this.searchName = newName;
    }

    public String getSearchName() {
        return this.searchName;
    }
}

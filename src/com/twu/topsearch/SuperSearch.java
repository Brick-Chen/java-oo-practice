package com.twu.topsearch;

/**
 * subclass of Search
 * the tickets vote to a super search item
 * will get double
 */
public class SuperSearch extends Search{

    public SuperSearch(String name) {
        super(name);
    }

    /**
     * the number vote to super item will
     * get double
     * @param num number of tickets intend
     * to vote to this search item
     */
    @Override
    public void setTrending(int num) {
        super.setTrending(num * 2);
    }
}

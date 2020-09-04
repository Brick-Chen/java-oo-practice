package com.twu.topsearch;

public class SuperSearch extends Search{

    public SuperSearch(String name) {
        super(name);
    }

    @Override
    public void setTrending(int num) {
        super.setTrending(num * 2);
    }
}

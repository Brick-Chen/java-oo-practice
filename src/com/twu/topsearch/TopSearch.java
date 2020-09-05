package com.twu.topsearch;

import java.util.*;

/**
 * class of search list
 */
public class TopSearch {
    /**
     * the only instance of search list
     */
    private final static TopSearch ts = new TopSearch();

    /**
     * map from name to search item
     */
    private final Map<String, Search> map;

    /**
     * list of current search items in the search list
     */
    private final List<Search> items;

    private TopSearch() {
        map = new HashMap<>();
        items = new ArrayList<>();
    }

    /**
     *
     * @return the only instance of search list
     */
    public static TopSearch getInstance() {
        return ts;
    }

    /**
     * check whether a search item is in
     * current search list
     * @param name name of a search item
     * @return result
     */
    public boolean contains(String name) {
        return map.containsKey(name);
    }

    /**
     * add a search item
     * @param item search item
     */
    public void add(Search item) {
        map.put(item.getName(), item);
        items.add(item);
    }

    /**
     *
     * @param name name of search item
     * @param num number of tickets
     */
    public void addTrending(String name, int num) {
        Search target = map.get(name);
        target.setTrending(num);
    }

    /**
     *
     * @return whether current search list
     * is empty
     */
    public boolean isEmpty() {
        return items.size() == 0;
    }

    /**
     * print current search list
     */
    public void showTopSearchList() {
        if (items.size() == 0) {
            System.out.println("当前热搜榜为空！");
            return;
        }

        items.sort((o1, o2) -> o2.getTrending() - o1.getTrending());
        System.out.println("----------------------------------------------");
        for(int i = 0; i < items.size(); ++i) {
            Search item = items.get(i);
            System.out.println(i + 1 + "    " + item.getName() + "    " + item.getTrending());
        }
        System.out.println("----------------------------------------------");
        System.out.println(" ");
    }
}

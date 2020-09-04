package com.twu.topsearch;

import java.util.*;

public class TopSearch {
    private final static TopSearch ts = new TopSearch();
    private final Map<String, Search> map;
    private final List<Search> items;

    private TopSearch() {
        map = new HashMap<>();
        items = new ArrayList<>();
    }

    public static TopSearch getInstance() {
        return ts;
    }

    public boolean contains(String name) {
        return map.containsKey(name);
    }

    public void add(Search item) {
        map.put(item.getName(), item);
        items.add(item);
    }

    public void addTrending(String name, int num) {
        Search target = map.get(name);
        target.setTrending(num);
    }

    public void showTopSearchList() {
        if (items.size() == 0) {
            System.out.println("当前热搜榜为空！");
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

package com.twu.role;

import com.twu.topsearch.Search;
import com.twu.topsearch.TopSearch;

public abstract class Role {
    private static final int DEFAULT_TICKET_NUM = 10;
    private final String name;
    private int ticket;

    public Role(String name) {
        this.name = name;
        this.ticket = DEFAULT_TICKET_NUM;
    }

    public String getName() {
        return this.name;
    }

    public int getTicket() {
        return this.ticket;
    }

    public void vote(String name, int num) {
        TopSearch searchList = TopSearch.getInstance();
        if(name == null || !searchList.contains(name)) {
            System.out.println("该项热搜不存在！");
            return;
        }
        if (num > this.ticket) {
            System.out.println("票数不足，投票失败！");
            return;
        }
        searchList.addTrending(name, num);
        this.ticket -= num;
    }

    public void addSearchItem(String name) {
        if(validName(name)) {
            TopSearch searchList = TopSearch.getInstance();
            String s = name.toLowerCase();
            Search search = new Search(s);
            searchList.add(search);
        }

    }

    public boolean validName(String name) {
        TopSearch searchList = TopSearch.getInstance();
        if (name == null || name.length() == 0) {
            System.out.println("热搜词不能为空！");
            return false;
        }
        String s = name.toLowerCase();
        if (searchList.contains(s)) {
            System.out.println("该热搜已在排行榜！");
            return false;
        }
        return true;
    }

    public void viewTopSearch() {
        TopSearch searchList = TopSearch.getInstance();
        searchList.showTopSearchList();
    }
}

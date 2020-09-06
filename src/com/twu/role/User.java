package com.twu.role;

import com.twu.topsearch.TopSearch;

/**
 * class User -- subclass of Role
 * field ticket: number of tickets that a user owns
 * field DEFAULT_TICKET_NUM: init ticket number a
 * user owns, default to 10
 */
public class User extends Role{
    private static final int DEFAULT_TICKET_NUM = 10;
    private int ticket;

    public User(String name) {
        super(name);
        this.ticket = DEFAULT_TICKET_NUM;
    }

    /**
     *
     * @return number of current tickets that
     * a user owns
     */
    public int getTicket() {
        return this.ticket;
    }

    /**
     * vote tickets for a search item the search item must be in the
     * search list and the number of tickets to vote can not exceed
     * the total number of tickets that a user owns
     * @param name search item name
     * @param num number of tickets to vote
     */
    public void vote(String name, int num) {
        TopSearch searchList = TopSearch.getInstance();
        if(searchList.isEmpty()) {
            System.out.println("热搜榜为空！无法投票！");
            return;
        }
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
        System.out.println("投票成功！");
    }

    /**
     * user function: buy search item
     * @param name : search item intend to buy
     */
    public void buySearchItem(String name, int ranking, int money) {
        TopSearch searchList = TopSearch.getInstance();
        if (searchList.isEmpty()) {
            System.out.println("当前热搜榜为空，无法购买！");
            return;
        }
        if(name == null || name.length() == 0 || !searchList.contains(name)) {
            System.out.println("热搜榜中没有这条消息！购买失败！");
            return;
        }
        if (ranking < 0 || ranking > searchList.size()) {
            System.out.println("排名无效");
            return;
        }
        if (searchList.getSearchRank(name) == ranking) {
            System.out.println("该热搜已在该排名上，购买失败！");
            return;
        }
        if (searchList.isSold(ranking) && searchList.getRankingPrice(ranking) >= money) {
            System.out.println("金额不足！");
            return;
        }
        searchList.buyRanking(name, ranking, money);
        System.out.println("购买成功！");
    }
}

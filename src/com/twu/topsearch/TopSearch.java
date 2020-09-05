package com.twu.topsearch;

import java.util.*;
import java.util.stream.Collectors;

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
     * it stores search item name and
     * its corresponding search item
     */
    private final Map<String, Search> searchList;

    /**
     * map from ranking to Rank object
     * it stores sold ranking, its price
     * and its corresponding search name
     */
    private final Map<Integer, Rank> soldRanking;
    

    private TopSearch() {
        searchList = new HashMap<>();
        soldRanking = new HashMap<>();
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
        return searchList.containsKey(name);
    }

    /**
     * add a search item
     * @param item search item
     */
    public void add(Search item) {
        searchList.put(item.getName(), item);
    }

    /**
     *
     * @param name name of search item
     * @param num number of tickets
     */
    public void addTrending(String name, int num) {
        Search target = searchList.get(name);
        target.setTrending(num);
    }

    /**
     *
     * @return whether current search list
     * is empty
     */
    public boolean isEmpty() {
        return searchList.size() == 0;
    }

    /**
     * check whether a ranking is sold
     * @param ranking a ranking number
     * @return true if sold, else false
     */
    public boolean isSold(int ranking) {
        return soldRanking.containsKey(ranking);
    }

    /**
     * get the price of a sold ranking
     * @param ranking a ranking number
     * @return price
     */
    public int getRankingPrice(int ranking) {
        return soldRanking.get(ranking).getPrice();
    }

    /**
     * buy a ranking
     * @param name search item name
     * @param ranking ranking number
     * @param money money to pay for the ranking
     */
    public void buyRanking(String name, int ranking, int money) {
        // if the ranking has been paid before, the search item
        // corresponding to it will be deleted
        if (soldRanking.containsKey(ranking)) {
            searchList.remove(soldRanking.get(ranking).getSearchName());
        }

        // if the search item to be paid has been paid before
        // soldRanking should remove its record before

        Rank rank = soldRanking.getOrDefault(ranking, new Rank(ranking));
        rank.setSearchName(name);
        rank.setPrice(money);
        soldRanking.put(ranking, rank);
    }

    /**
     * sort the search item based on following rule
     * if no ranking is sold, sort the search item
     * based on the trending of each item.
     * if some rankings are sold, put these items on these
     * ranking index first, then sort the remaining items
     * based on the trending.
     */
    private List<Search> sortSearchList() {
        List<Search> items;
        // if no ranking is sold
        if (soldRanking.size() == 0) {
            items = new ArrayList<>(searchList.values());
            items.sort((o1, o2) -> o2.getTrending() - o1.getTrending());
        }
        // else
        else {
            // get the name of paid search item
           Set<String> soldSearchItem = soldRanking.values().stream().map(Rank::getSearchName)
                   .collect(Collectors.toSet()); 

           // get the unpaid search item
           List<Search> unsoldSearchItem = searchList.keySet().stream().filter(o -> !soldSearchItem.contains(o))
                   .map(searchList::get).sorted((o1, o2) -> o2.getTrending() - o1.getTrending())
                   .collect(Collectors.toList());

           Search[] res = new Search[searchList.size()];

           // put the paid search item in the right position
           for(int ranking : soldRanking.keySet()) {
               String searchName = soldRanking.get(ranking).getSearchName();
               res[ranking] = searchList.get(searchName);
           }

           // put the remaining unpaid search item
           if (unsoldSearchItem.size() != 0) {
               int index = 0;
               for (int i = 0; i < res.length; ++i) {
                   if (res[i] == null) {
                       res[i] = unsoldSearchItem.get(index);
                       ++index;
                   }
               }
           }

           items = Arrays.asList(res);
        }
        return items;
    }

    /**
     * print current search list
     */
    public void showTopSearchList() {
        if (searchList.size() == 0) {
            System.out.println("当前热搜榜为空！");
            return;
        }

        List<Search> items = sortSearchList();
        System.out.println("----------------------------------------------");
        for(int i = 0; i < items.size(); ++i) {
            Search item = items.get(i);
            System.out.println(i + 1 + "    " + item.getName() + "    " + item.getTrending());
        }
        System.out.println("----------------------------------------------");
        System.out.println(" ");
    }
}

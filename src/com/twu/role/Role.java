package com.twu.role;

import com.twu.topsearch.Search;
import com.twu.topsearch.TopSearch;

/**
 * Abstract class Role
 */
public abstract class Role {
    private final String name;

    public Role(String name) {
        this.name = name;
    }

    /**
     *
     * @return name of the role
     */
    public String getName() {
        return this.name;
    }

    /**
     * add a search item to search list
     * @param name name of the search item
     */
    public void addSearchItem(String name) {
        if(validName(name)) {
            TopSearch searchList = TopSearch.getInstance();
            String s = name.toLowerCase();
            Search search = new Search(s);
            searchList.add(search);
            System.out.println("添加成功！");
        }

    }

    /**
     *
     * @param name name of a search item
     * @return validation of a search item
     */
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

    /**
     * show current search list
     */
    public void viewTopSearch() {
        TopSearch searchList = TopSearch.getInstance();
        searchList.showTopSearchList();
    }
}

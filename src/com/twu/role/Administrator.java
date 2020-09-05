package com.twu.role;

import com.twu.topsearch.Search;
import com.twu.topsearch.SuperSearch;
import com.twu.topsearch.TopSearch;

/**
 * class Administrator-- subclass of Role
 */
public class Administrator extends Role{

    public Administrator(String name) {
        super(name);
    }

    /**
     * administrator function: add super search item
     * when a user votes super search item, the num
     * of trending will be doubled.
     * @param name: super search item intend to add
     * to search list
     */
    public void addSuperSearchItem(String name) {
        if(validName(name)) {
            TopSearch searchList = TopSearch.getInstance();
            Search superSearch = new SuperSearch(name);
            searchList.add(superSearch);
        }

    }
}

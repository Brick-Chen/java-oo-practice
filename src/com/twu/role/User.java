package com.twu.role;

/**
 * class User -- subclass of Role
 */
public class User extends Role{

    public User(String name) {
        super(name);
    }

    /**
     * user function: buy search item
     * @param name : search item intend to buy
     */
    public boolean buySearchItem(String name, int money) {
        System.out.println("购买失败");
        return false;
    }
}

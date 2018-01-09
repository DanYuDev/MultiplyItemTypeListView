package com.example.coderlt.multiplyitemtypelistview;

/**
 * Created by coderlt on 2018/1/9.
 */

public class ListItem {
    static class ItemType{
        public static final int TEXT=0;
        public static final int BUTTON=1;
        public static final int EDIT=2;
        public static final int TYPE_COUNT=3;
    }

    public ListItem(String name,int type){
        this.name=name;
        this.type=type;
    }

    private String name;
    private int    type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

package com.example.administrator.publishlibrary.cooking;

/**
 * Created by yinjianlin on 2016/8/12.
 */
public class CookChildType {
    public String id;
    public String name;
    public String parentId;
    public int imgResId;
    public CookChildType() {
        super();
    }
    public CookChildType(String id, String name, String parentId, int imgResId) {
        super();
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.imgResId = imgResId;
    }


}

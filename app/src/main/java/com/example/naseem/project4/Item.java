package com.example.naseem.project4;



import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by fatimahalmohaimeed on 1‏/4‏/2016.
 */
public class Item extends RealmObject {
    @PrimaryKey
    private String name;
    private String description;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

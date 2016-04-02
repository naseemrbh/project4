package com.example.naseem.project4;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by fatimahalmohaimeed on 25‏/3‏/2016.
 */
public class Size extends RealmObject {

    @PrimaryKey
//    private String id;
    private String name;
    private String SizeType;
    private String topSize , bottomSize , shoesSize;
    private boolean checked;
    private String select;
    //private String description;
    //private int img;

    public Size() {
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        checked = checked;
    }

    //public String getId() {
      //  return id;
    //}

   // public void setId(String id) {
     //   this.id = id;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizeType() {
        return SizeType;
    }

    public void setSizeType(String sizeType) {
        SizeType = sizeType;
    }

    public String getTopSize() {
        return topSize;
    }

    public void setTopSize(String topSize) {
        this.topSize = topSize;
    }

    public String getBottomSize() {
        return bottomSize;
    }

    public void setBottomSize(String bottomSize) {
        this.bottomSize = bottomSize;
    }

    public String getShoesSize() {
        return shoesSize;
    }

    public void setShoesSize(String shoesSize) {
        this.shoesSize = shoesSize;
    }

    //public String getDescription() {
      //  return description;
   // }

   // public void setDescription(String description) {
     //   this.description = description;
    //}

//public int getImg() {
//        return img;
//    }
//     public void setImg(int img) {
//        this.img = img;
//    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String selecte) {
        this.select = selecte;
    }
}

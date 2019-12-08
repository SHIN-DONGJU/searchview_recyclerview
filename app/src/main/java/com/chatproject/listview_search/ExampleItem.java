package com.chatproject.listview_search;

public class ExampleItem {
    private int mImageResource;
    private  String mText1;
    private  String mText2;

    public ExampleItem(int ImageResource, String text1, String text2) {
        mImageResource = ImageResource;
        mText1 = text1;
        mText2 = text2;
    }

    public void nextPage(String text) {
        mText1 = text;
    }

    public int getImageResource() {
        return  mImageResource;
    }

    public  String getText1() {
        return  mText1;
    }

    public  String getText2() {
        return  mText2;
    }
}

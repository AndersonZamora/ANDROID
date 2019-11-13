package com.example.frutas;

public class ExampleIten {
    private int mImageResource;
    private String mText1;
    private String MText2;

    public ExampleIten(int mImageResource, String mText1, String MText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.MText2 = MText2;
    }

    public void changeText1(String text){
        mText1 = text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getMText2() {
        return MText2;
    }

    public void setMText2(String MText2) {
        this.MText2 = MText2;
    }
}

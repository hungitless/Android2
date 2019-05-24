package com.example.android.trada;

public class Word {

    private String mViTranslation;

    private String mEnTranslation;

    private int mAudioResourceId;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    //Giá trị hằng số không cung cấp ảnh cho từ vựng
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String viTranslation, String enTranslation, int audioResourceId){
        mViTranslation = viTranslation;
        mEnTranslation = enTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String viTranslation, String enTranslation, int imageResourceId, int audioResourceId){
        mViTranslation = viTranslation;
        mEnTranslation = enTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getViTranslation(){
        return mViTranslation;
    }

    public String getEnTranslation(){
        return mEnTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() { return mAudioResourceId; }

}

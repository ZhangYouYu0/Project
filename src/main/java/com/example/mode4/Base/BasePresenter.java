package com.example.mode4.Base;

public class BasePresenter <I extends BaseView>{
    public I iview;
    public void attachView(I i){
        iview=i;
    }
}

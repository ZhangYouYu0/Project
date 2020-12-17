package com.example.mode4.Utils;

public interface INetCallBack<I> {
    void onSuccess(I i);
    void eroor(String erro);
}

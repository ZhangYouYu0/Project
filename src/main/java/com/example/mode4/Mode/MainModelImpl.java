package com.example.mode4.Mode;

import com.example.mode4.Contract.Contract;
import com.example.mode4.Utils.INetCallBack;
import com.example.mode4.Utils.RetrofitUtils;

public class MainModelImpl implements Contract.Model {
    Contract.Presenterl presenterl;

    public MainModelImpl(Contract.Presenterl presenterl) {
        this.presenterl = presenterl;
    }

    @Override
    public <I> void Mode(String url, INetCallBack<I> Contract) {
        RetrofitUtils.getRetrofitUtils().get(url,Contract);
    }
}

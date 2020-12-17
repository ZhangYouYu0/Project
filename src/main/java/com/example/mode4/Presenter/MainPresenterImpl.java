package com.example.mode4.Presenter;

import com.example.mode4.Base.BasePresenter;
import com.example.mode4.Bean.FooBean;
import com.example.mode4.Contract.Contract;
import com.example.mode4.Mode.MainModelImpl;
import com.example.mode4.Utils.INetCallBack;
import com.example.mode4.Utils.UrlConn;

import java.util.Calendar;

public class MainPresenterImpl extends BasePresenter<Contract.View> implements Contract.Presenterl {
   private Contract.Model model;
   private Contract.View view;

    public MainPresenterImpl(Contract.View view) {
        this.view = view;
        this.model = new MainModelImpl(this);
    }

    @Override
    public void p() {
        model.Mode(UrlConn.url, new INetCallBack<FooBean>() {
            @Override
            public void onSuccess(FooBean fooBean) {
                iview.getData(fooBean);
            }

            @Override
            public void eroor(String erro) {
                iview.getEroo(erro);
            }
        });
    }
}

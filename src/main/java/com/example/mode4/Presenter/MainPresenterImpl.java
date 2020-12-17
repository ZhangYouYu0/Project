package com.example.mode4.Presenter;

import com.example.mode4.Base.BasePresenter;
import com.example.mode4.Contract.Contract;
import com.example.mode4.Mode.MainModelImpl;

public class MainPresenterImpl extends BasePresenter<Contract.View> implements Contract.Presenterl {
   private Contract.Model model;
   private Contract.View view;

    public MainPresenterImpl(Contract.View view) {
        this.view = view;
        this.model = new MainModelImpl(this);
    }

    @Override
    public void p() {
        model.Mode();
    }
}

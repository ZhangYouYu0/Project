package com.example.mode4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mode4.Base.BaseActivity;
import com.example.mode4.Bean.FooBean;
import com.example.mode4.Contract.Contract;
import com.example.mode4.Presenter.MainPresenterImpl;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements Contract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    @Override
    public void getData(FooBean fooBean) {

    }

    @Override
    public void getEroo(String string) {

    }
}
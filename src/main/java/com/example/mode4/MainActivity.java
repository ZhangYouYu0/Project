package com.example.mode4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mode4.Base.BaseActivity;
import com.example.mode4.Bean.FooBean;
import com.example.mode4.Contract.Contract;
import com.example.mode4.Presenter.MainPresenterImpl;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements Contract.View {
    RecyclerView recyclerview;
    ArrayList<FooBean.DataDTO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        presenter.p();
    }

    @Override
    protected void initView() {
         recyclerview = findViewById(R.id.recyclerview);
         recyclerview.setLayoutManager(new LinearLayoutManager(this));
         list = new ArrayList<>();
        recyclerview.setAdapter();
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
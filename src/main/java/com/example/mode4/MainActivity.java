package com.example.mode4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mode4.Base.BaseActivity;
import com.example.mode4.Presenter.MainPresenterImpl;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
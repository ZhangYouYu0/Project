package com.example.mode4.Contract;

import com.example.mode4.Base.BaseView;
import com.example.mode4.Bean.FooBean;
import com.example.mode4.Utils.INetCallBack;

public class Contract {
    public interface Model{
      <I>  void Mode(String url, INetCallBack<I> Contract);
    }

    public interface Presenterl{
        void p();
    }

    public interface View extends BaseView {
        void getData(FooBean fooBean);
        void getEroo(String string);
    }
}

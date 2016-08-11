package com.example.administrator.minelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
        * Created by Administrator on 2016/8/11.
                */
        public class mineFrament extends Fragment {
            @Override
            public View onCreateView(final LayoutInflater inflater,
                                     @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View view =  inflater.inflate(R.layout.mine_fragment, null);

                return view;


    }
}

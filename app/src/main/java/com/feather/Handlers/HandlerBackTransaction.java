package com.feather.Handlers;

import android.view.View;

import androidx.fragment.app.FragmentTransaction;

import com.feather.R;

public class HandlerBackTransaction implements View.OnClickListener {
    private FragmentTransaction mFragmentTransaction;
    private View mView;

    public HandlerBackTransaction(View view) {
        mView = view;

    }

    @Override
    public void onClick(View view) {
        if (mView.getId() == R.id.buttonBack) {

        }
    }
}

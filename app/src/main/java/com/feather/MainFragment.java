package com.feather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment implements View.OnClickListener {
    private Button mNewForButton;
    private View mView;
    private NewForFragment mNewForFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main, container, false);

        mNewForButton = (Button) mView.findViewById(R.id.newForButton);
        mNewForButton.setOnClickListener(this);

        mNewForFragment = new NewForFragment();

        return mView;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        if (view.getId() == R.id.newForButton) {
            fragmentTransaction.setReorderingAllowed(true).replace(R.id.fragmentMainActivity, mNewForFragment).commit();
        }
    }
}
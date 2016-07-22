package com.example.bajob.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bajob.myapplication.R;

/**
 * Created by bajob on 17/07/2016.
 */
public class UnoFragment extends Fragment {
    private TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        text = (TextView) view.findViewById(R.id.text);
        text.setText("Uno");
        return view;
    }

}

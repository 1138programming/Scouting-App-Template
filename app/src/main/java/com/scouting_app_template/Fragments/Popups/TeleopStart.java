package com.scouting_app_template.Fragments.Popups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scouting_app_template.Fragments.DataFragment;
import com.scouting_app_template.databinding.TeleopStartFragmentBinding;

public class TeleopStart extends DataFragment {
    TeleopStartFragmentBinding binding;

    public TeleopStart() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = TeleopStartFragmentBinding.inflate(inflater,container,false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @NonNull
    @Override
    public String toString() {
        return "TeleopStartFragment";
    }
}

package com.scouting_app_template.Fragments;

import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scouting_app_template.databinding.AutonFragmentBinding;

import java.util.Calendar;
import java.util.Locale;

public class AutonFragment extends DataFragment {
    AutonFragmentBinding binding;
    private Long autonStart;

    public AutonFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = AutonFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void autonOpen() {
        if(autonStart == null) {
            ftm.showAutonStart();
        }
    }

    /**
     * Called every time auton is opened to make sure the auton start
     * popup is shown before auton starts.
     */
    public void startAuton() {
        this.autonStart = Calendar.getInstance(Locale.US).getTimeInMillis();
    }

    public String getAutonStart() {
        return this.autonStart.toString();
    }

    @NonNull
    @Override
    public String toString() {
        return "AutonFragment";
    }
}

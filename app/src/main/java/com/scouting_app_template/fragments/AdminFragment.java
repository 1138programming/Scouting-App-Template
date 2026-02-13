package com.scouting_app_template.fragments;

import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.databinding.AdminFragmentBinding;
import com.scouting_app_template.datapointIDs.NonDataIDs;

import java.util.Objects;

public class AdminFragment extends DataFragment {
    AdminFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = AdminFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button closeButton = new Button(
                NonDataIDs.PracticeClose.getID(), binding.closeMenu);
        closeButton.setOnClickFunction(() -> ftm.adminFragmentBack());
    }

    @NonNull
    @Override
    public String toString() {
        return "AdminFragment";
    }
}

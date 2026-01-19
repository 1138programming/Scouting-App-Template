package com.scouting_app_template.Fragments;

import static com.scouting_app_template.DatapointIDs.DatapointIDs.nonDataIDs;
import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scouting_app_template.DatapointIDs.NonDataEnum;
import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.databinding.PostMatchFragmentBinding;

import java.util.Objects;

public class PostMatchFragment extends DataFragment {
    PostMatchFragmentBinding binding;

    public PostMatchFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = PostMatchFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int datapointID = Objects.requireNonNull(nonDataIDs.get(NonDataEnum.PostMatchBack));
        Button backButton = new Button(datapointID, binding.returnToTeleop);
        backButton.setOnClickFunction(() -> ftm.postMatchBack());

        datapointID = Objects.requireNonNull(nonDataIDs.get(NonDataEnum.PostMatchSubmit));
        Button submitButton = new Button(datapointID, binding.submitButton);
        submitButton.setOnClickFunction(() -> ftm.matchSubmit());
    }

    @NonNull
    @Override
    public String toString() {
        return "PostMatchFragment";
    }
}

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
import com.scouting_app_template.databinding.TeleopFragmentBinding;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class TeleopFragment extends DataFragment {
    private TeleopFragmentBinding binding;
    private Long teleopStart;

    public TeleopFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = TeleopFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int datapointID = Objects.requireNonNull(nonDataIDs.get(NonDataEnum.PostMatchBack));
        Button backButton = new Button(datapointID, binding.backButton);
        backButton.setOnClickFunction(() -> ftm.teleopBack());

        datapointID = Objects.requireNonNull(nonDataIDs.get(NonDataEnum.PostMatchBack));
        Button submitButton = new Button(datapointID, binding.nextButton);
        submitButton.setOnClickFunction(() -> ftm.teleopNext());
    }

    /**
     * Called every time teleop is opened to make sure the teleop start
     * popup is shown before teleop starts.
     */
    public void teleopOpen() {
        if(teleopStart == null) {
            ftm.showTeleopStart();
        }
    }
    public void startTeleop() {
        this.teleopStart = Calendar.getInstance(Locale.US).getTimeInMillis();
    }
    public long getTeleopStart() {
        return this.teleopStart;
    }

    @NonNull
    @Override
    public String toString() {
        return "TeleopFragment";
    }
}

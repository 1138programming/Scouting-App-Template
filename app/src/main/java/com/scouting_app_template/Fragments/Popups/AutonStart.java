package com.scouting_app_template.Fragments.Popups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scouting_app_template.Fragments.DataFragment;
import com.scouting_app_template.JSON.JSONManager;
import com.scouting_app_template.MainActivity;
import com.scouting_app_template.UIElements.Button;

import static com.scouting_app_template.MainActivity.defaultTimestamp;
import static com.scouting_app_template.MainActivity.ftm;
import static com.scouting_app_template.DatapointIDs.DatapointIDs.nonDataIDs;

import com.scouting_app_template.DatapointIDs.NonDataEnum;
import com.scouting_app_template.databinding.AutonStartFragmentBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AutonStart extends DataFragment {
    AutonStartFragmentBinding binding;
    private String autonStartTimestamp;

    public AutonStart() {
        super();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = AutonStartFragmentBinding.inflate(inflater,container,false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button backButton = new Button(
                Objects.requireNonNull(nonDataIDs.get(NonDataEnum.AutonStartBack)), binding.backButton);
        backButton.setOnClickFunction(() -> ftm.autonStartBack());

        Button startButton = new Button(
                Objects.requireNonNull(nonDataIDs.get(NonDataEnum.AutonStartStart)), binding.startButton);
        startButton.setOnClickFunction(() -> ftm.autonStartStart());
        startButton.setOnClickFunction(this::autonStart);
    }

    @NonNull
    @Override
    public String toString() {
        return "AutonStartFragment";
    }

    public void autonStart() {
        if(autonStartTimestamp == null) {
            autonStartTimestamp = String.valueOf(Calendar.getInstance(Locale.US).getTimeInMillis());
        }
    }

    @Override
    public JSONArray getFragmentMatchData() throws JSONException {
        JSONManager manager = new JSONManager(((MainActivity) MainActivity.context).getBaseJSON());
        manager.addStart(2, Objects.requireNonNullElse(autonStartTimestamp, defaultTimestamp));
        return manager.getJSON();
    }
}

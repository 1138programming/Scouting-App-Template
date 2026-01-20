package com.scouting_app_template.Fragments;

import static com.scouting_app_template.DatapointIDs.DatapointIDs.datapointIDs;
import static com.scouting_app_template.DatapointIDs.DatapointIDs.nonDataIDs;
import static com.scouting_app_template.MainActivity.context;
import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scouting_app_template.DatapointIDs.DatapointEnum;
import com.scouting_app_template.DatapointIDs.NonDataEnum;
import com.scouting_app_template.JSON.JSONManager;
import com.scouting_app_template.MainActivity;
import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.UIElements.SliderElement;
import com.scouting_app_template.databinding.PostMatchFragmentBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Objects;

public class PostMatchFragment extends DataFragment {
    private PostMatchFragmentBinding binding;
    private SliderElement confidenceSlider;

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

        datapointID = 67;
        confidenceSlider = new SliderElement(datapointID, binding.confidenceSlider);
    }

    @NonNull
    @Override
    public String toString() {
        return "PostMatchFragment";
    }

    @Override
    public JSONArray getFragmentMatchData() throws JSONException {
        JSONManager jsonManager = new JSONManager(((MainActivity)context).getBaseJSON());
        JSONArray jsonCollection = super.getFragmentMatchData();

        jsonManager.addDatapoint(Objects.requireNonNull(datapointIDs.get(DatapointEnum.confidenceSlider)), confidenceSlider.getValue());

        JSONArray jsonArray = jsonManager.getJSON();

        for (int i = 0; i < jsonArray.length(); i++) {
            jsonCollection.put(jsonArray.getJSONObject(i));
        }

        return jsonCollection;
    }
}

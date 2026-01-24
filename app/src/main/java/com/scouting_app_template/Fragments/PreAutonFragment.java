package com.scouting_app_template.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;

import com.scouting_app_template.DatapointIDs.DatapointID;
import com.scouting_app_template.MainActivity;
import com.scouting_app_template.R;
import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.UIElements.Checkbox;
import com.scouting_app_template.DatapointIDs.NonDataIDs;
import com.scouting_app_template.UIElements.RadioCheckboxGroup;
import com.scouting_app_template.UIElements.RadioGroup;
import com.scouting_app_template.UIElements.Spinner;
import com.scouting_app_template.UIElements.ImageButton;
import com.scouting_app_template.databinding.PreAutonFragmentBinding;

import static com.scouting_app_template.MainActivity.context;
import static com.scouting_app_template.MainActivity.ftm;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PreAutonFragment extends DataFragment {
    private PreAutonFragmentBinding binding;
    private Spinner scouterNameSpinner;
    private Spinner matchNumberSpinner;
    private RadioGroup teamColorButtons;
    private Spinner teamNumberSpinner;
    private int scouterIndex;
    private int matchIndex;
    private ArrayList<Integer> scouterIDs = new ArrayList<>(List.of(-1));

    public PreAutonFragment() {
        this.scouterIndex = 0;
        this.matchIndex = 0;
    }
    public PreAutonFragment(int scouterIndex, int matchIndex) {
        this.scouterIndex = scouterIndex;
        this.matchIndex = matchIndex;
    }

    /* When the fragment binding is created we override the function so we
    * can get the binding in this class to use. */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = PreAutonFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scouterNameSpinner = new Spinner(NonDataIDs.ScouterName.getID(), binding.nameOfScouterSpinner, true);
        scouterNameSpinner.setOnClickFunction(() -> ((MainActivity) requireContext()).updateTabletInformation());
        scouterNameSpinner.setOnClickFunction(this::updateIndices);
        if(scouterIndex < scouterNameSpinner.getLength()) {
            scouterNameSpinner.setIndex(scouterIndex);
        }

        matchNumberSpinner = new Spinner(NonDataIDs.MatchNumber.getID(), binding.matchNumberSpinner, false);
        matchNumberSpinner.updateSpinnerList(generateMatches());
        matchNumberSpinner.setOnClickFunction(() -> ((MainActivity) requireContext()).updateTabletInformation());
        matchNumberSpinner.setOnClickFunction(this::updateIndices);
        if(matchIndex < matchNumberSpinner.getLength()) {
            matchNumberSpinner.setIndex(matchIndex);
        }

        teamColorButtons = new RadioGroup(NonDataIDs.TeamColor.getID(), binding.teamColorSwitch);
        teamColorButtons.setOnClickFunction(this::updateTeamColor);

        teamNumberSpinner = new Spinner(NonDataIDs.TeamNumber.getID(), binding.teamNumberSpinner, false);
        teamNumberSpinner.setOnClickFunction(() -> ((MainActivity) requireContext()).updateTabletInformation());

        RadioCheckboxGroup startingPositionGroup = new RadioCheckboxGroup(DatapointID.startPos.getID());

        RadioGroup startingPosition = new RadioGroup(NonDataIDs.StartPosRadio.getID(), binding.startingLocation);
            startingPositionGroup.addElement(startingPosition);

        Checkbox noShowCheckbox = new Checkbox(NonDataIDs.NoShow.getID(), binding.noShowCheckbox, true, "noShow");
            startingPositionGroup.addElement(noShowCheckbox);

            startingPositionGroup.elementSelected(noShowCheckbox);

            undoStack.addElement(startingPositionGroup);

        Button nextButton = new Button(NonDataIDs.PreAutonNext.getID(), binding.nextButton);
        nextButton.setOnClickFunction(() -> ftm.preAutonNext());
        nextButton.setOnClickFunction(() -> ((AutonFragment) Objects.requireNonNull(
                getParentFragmentManager().findFragmentByTag("AutonFragment"))).autonOpen());

        ImageButton button = new ImageButton(NonDataIDs.ArchiveHamburger.getID(), binding.archiveButton);
        button.setOnClickFunction(() -> ftm.preAutonMenu());
    }

    /* When the fragment is completely created, we test so see
    * if we are connected and if so we send send our basic info. */
    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) context).updateBtScoutingInfo();
    }

    /* Makes it so the toString() function for this class
    * return the name of the class. */
    @NonNull
    @Override
    public String toString() {
        return "PreAutonFragment";
    }

    /** Generates an ArrayList filled with the necessary qualifying
     * and playoffs matches for an entire comp. */
    private ArrayList<CharSequence> generateMatches() {
        ArrayList<CharSequence> matchNumbers = new ArrayList<>();
        //creates spinner for match number
        for(int i = 1; i<=100; i++) {
            matchNumbers.add(Integer.toString(i));
        }
        for(int i = 1; i<=13; i++) {
            matchNumbers.add("Playoffs "+i);
        }
        for(int i = 1; i<=3; i++) {
            matchNumbers.add("Finals "+i);
        }
        for(int i = 1; i<=100; i++) {
            matchNumbers.add("Practice "+i);
        }
        return matchNumbers;
    }

    public void updateTeamColor() {
        switch(teamColorButtons.getValue()) {
            case "RED":
//                binding.startingPosImage.setImageResource(R.drawable.TODO update path to field image);

                binding.leftStart.setBackground(AppCompatResources.getDrawable(context,R.drawable.start_toggle_red));
                binding.leftStart.setTextColor(AppCompatResources.getColorStateList(context, R.color.red_text_toggle));

                binding.middleLeftStart.setBackground(AppCompatResources.getDrawable(context,R.drawable.start_toggle_red));
                binding.middleLeftStart.setTextColor(AppCompatResources.getColorStateList(context, R.color.red_text_toggle));

                binding.rightStart.setBackground(AppCompatResources.getDrawable(context,R.drawable.start_toggle_red));
                binding.rightStart.setTextColor(AppCompatResources.getColorStateList(context, R.color.red_text_toggle));
                break;
            case "BLUE":
//                binding.startingPosImage.setImageResource(R.drawable.TODO update path to field image);

                binding.leftStart.setBackground(AppCompatResources.getDrawable(context,R.drawable.start_toggle_blue));
                binding.leftStart.setTextColor(AppCompatResources.getColorStateList(context, R.color.blue_text_toggle));

                binding.middleLeftStart.setBackground(AppCompatResources.getDrawable(context,R.drawable.start_toggle_blue));
                binding.middleLeftStart.setTextColor(AppCompatResources.getColorStateList(context, R.color.blue_text_toggle));

                binding.rightStart.setBackground(AppCompatResources.getDrawable(context,R.drawable.start_toggle_blue));
                binding.rightStart.setTextColor(AppCompatResources.getColorStateList(context, R.color.blue_text_toggle));

        }
    }

    public byte[] getTabletInformation() {
        StringBuilder tabletInfo = new StringBuilder();

        tabletInfo.append(scouterNameSpinner.getValue());
        tabletInfo.append(": ");
        tabletInfo.append(matchNumberSpinner.getValue());
        tabletInfo.append(": ");
        tabletInfo.append(teamNumberSpinner.getValue());
        tabletInfo.append(": ");

        if(tabletInfo.length() > 2) {
            return tabletInfo.delete(tabletInfo.length()-2,tabletInfo.length()).toString().getBytes();
        }
        else {
            return "Error".getBytes();
        }
    }

    public void setScoutingInfo(ArrayList<ArrayList<CharSequence>> list) {
        this.scouterIDs = new ArrayList<>(List.of(this.scouterIDs.get(0)));
        for (CharSequence scouterNum : list.get(1)) {
            String curr = scouterNum.toString();
            this.scouterIDs.add(Integer.valueOf(curr));
        }

        scouterNameSpinner.updateSpinnerList(list.get(0));
        scouterNameSpinner.setIndex(scouterIndex);

        teamNumberSpinner.updateSpinnerList(list.get(2));
    }

    public void setBtStatus(boolean status) {
        if(status) {
            binding.btConnectionStatus.setText(getResources().getString(R.string.connected_status_title), TextView.BufferType.NORMAL);
            Toast.makeText(context, "connected", Toast.LENGTH_LONG).show();
        }
        else {
            binding.btConnectionStatus.setText(getResources().getString(R.string.disconnected_status_title), TextView.BufferType.NORMAL);
            Toast.makeText(context, "disconnected", Toast.LENGTH_LONG).show();
        }
    }

    public String getFileTitle() {
        return scouterNameSpinner.getValue() + " Match #"+matchNumberSpinner.getValue();
    }

    public JSONObject getBaseJSON() throws JSONException {
        JSONObject baseJson = new JSONObject();

        baseJson.put("scouterID", scouterIDs.get(scouterNameSpinner.getSelectedIndex()).toString());
        baseJson.put("matchID", matchNumberSpinner.getValue());
        try {
            baseJson.put("teamID", teamNumberSpinner.getValue());
        } catch (NullPointerException e) {
            baseJson.put("teamID", "0");
        }
        String allianceName = teamColorButtons.getValue();
        switch (allianceName) {
            case "RED":
                baseJson.put("allianceID", "1");
                break;
            case "BLUE":
                baseJson.put("allianceID", "2");
        }

        return baseJson;
    }
    
    private void updateIndices() {
        this.scouterIndex = scouterNameSpinner.getSelectedIndex();
        this.matchIndex = matchNumberSpinner.getSelectedIndex();
    }
    
    public int getScouterIndex() {
        return scouterIndex;
    }

    public int getMatchIndex() {
        return matchIndex;
    }
    public void decrementMatchIndex() {
        matchIndex--;
    }
}

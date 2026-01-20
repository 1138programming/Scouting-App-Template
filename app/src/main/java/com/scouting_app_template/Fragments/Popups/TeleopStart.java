package com.scouting_app_template.Fragments.Popups;

import static com.scouting_app_template.DatapointIDs.DatapointIDs.nonDataIDs;
import static com.scouting_app_template.MainActivity.context;
import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.scouting_app_template.DatapointIDs.NonDataEnum;
import com.scouting_app_template.Fragments.TeleopFragment;
import com.scouting_app_template.MainActivity;
import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.databinding.TeleopStartFragmentBinding;

import java.util.Objects;

public class TeleopStart extends Fragment {
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

        Button backButton = new Button(
                Objects.requireNonNull(nonDataIDs.get(NonDataEnum.TeleopStartBack)), binding.backButton);
        backButton.setOnClickFunction(() -> ftm.teleopStartBack());

        Button startButton = new Button(
                Objects.requireNonNull(nonDataIDs.get(NonDataEnum.TeleopStartStart)), binding.startButton);
        startButton.setOnClickFunction(() -> ((TeleopFragment) Objects.requireNonNull(
                getParentFragmentManager().findFragmentByTag("TeleopFragment"))).startTeleop());
        startButton.setOnClickFunction(((MainActivity)context)::teleopStart);
        startButton.setOnClickFunction(() -> ftm.teleopStartStart());
    }

    @NonNull
    @Override
    public String toString() {
        return "TeleopStartFragment";
    }
}

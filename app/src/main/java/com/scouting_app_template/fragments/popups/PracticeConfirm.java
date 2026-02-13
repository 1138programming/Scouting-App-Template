package com.scouting_app_template.fragments.popups;

import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.scouting_app_template.MainActivity;
import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.databinding.ConfirmPracticeFragmentBinding;
import com.scouting_app_template.datapointIDs.NonDataIDs;
import com.scouting_app_template.fragments.PreAutonFragment;

import java.util.Objects;

public class PracticeConfirm extends Fragment {
    ConfirmPracticeFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = ConfirmPracticeFragmentBinding.inflate(inflater,container,false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button cancelButton = new Button(
                NonDataIDs.PracticeClose.getID(), binding.cancelButton);
        cancelButton.setOnClickFunction(() -> ftm.practiceClose());

        Button startButton = new Button(
                NonDataIDs.PracticeConfirm.getID(), binding.confirmButton);
        startButton.setOnClickFunction(() -> ftm.practiceClose());
        startButton.setOnClickFunction(((PreAutonFragment) Objects.requireNonNull(
                getParentFragmentManager().findFragmentByTag("PreAutonFragment")))::setMatchPractice);
    }

    @NonNull
    @Override
    public String toString() {
        return "PracticeConfirm";
    }
}

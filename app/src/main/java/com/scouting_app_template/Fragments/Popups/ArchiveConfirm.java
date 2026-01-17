package com.scouting_app_template.Fragments.Popups;

import static com.scouting_app_template.DatapointIDs.DatapointIDs.nonDataIDs;
import static com.scouting_app_template.MainActivity.ftm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.scouting_app_template.DatapointIDs.NonDataEnum;
import com.scouting_app_template.Fragments.AutonFragment;
import com.scouting_app_template.Fragments.DataFragment;
import com.scouting_app_template.UIElements.Button;
import com.scouting_app_template.databinding.ArchiveFragmentBinding;
import com.scouting_app_template.databinding.AutonStartFragmentBinding;

import java.util.Objects;

public class ArchiveConfirm extends Fragment {

    ArchiveFragmentBinding binding;

    public ArchiveConfirm() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = ArchiveFragmentBinding.inflate(inflater,container,false);
        return this.binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        Button backButton = new Button(
//                Objects.requireNonNull(nonDataIDs.get(NonDataEnum.AutonStartBack)), binding.backButton);
//        backButton.setOnClickFunction(() -> ftm.autonStartBack());
//
//        Button startButton = new Button(
//                Objects.requireNonNull(nonDataIDs.get(NonDataEnum.AutonStartStart)), binding.startButton);
//        startButton.setOnClickFunction(() -> ftm.autonStartStart());
//        startButton.setOnClickFunction(() -> ((AutonFragment) Objects.requireNonNull(
//                getParentFragmentManager().findFragmentByTag("AutonFragment"))).startAuton());
//    }


    @NonNull
    @Override
    public String toString() {
        return "ArchiveConfirmFragment";
    }
}

package com.scouting_app_template.UIElements;

import android.widget.RadioButton;

import com.scouting_app_template.MainActivity;


public class RadioGroup extends UIElement {
    private final android.widget.RadioGroup radioGroup;
    public RadioGroup(int datapointID, android.widget.RadioGroup radioGroup) {
        super(datapointID);
        this.radioGroup = radioGroup;
        this.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId != -1) {
                RadioGroup.super.clicked();
            }
        });
    }

    public void unselect() {
        radioGroup.clearCheck();
    }

    @Override
    public String getValue() {
        return ((RadioButton)((MainActivity)MainActivity.context).findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
    }
}

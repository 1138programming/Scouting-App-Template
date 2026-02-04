package com.scouting_app_template.UIElements;

import static com.scouting_app_template.MainActivity.TAG;

import android.util.Log;

import java.util.ArrayList;


public class RadioGroup extends UIElement {
    private final android.widget.RadioGroup radioGroup;
    private final UndoStack undoStack;
    private boolean unchecking = false;
    private final ArrayList<Integer> datapointIDs;
    private final ArrayList<RadioButton> radioButtons = new ArrayList<>();
    public RadioGroup(int datapointID, android.widget.RadioGroup radioGroup) {
        super(datapointID);
        this.radioGroup = radioGroup;
        this.datapointIDs = null;
        this.undoStack = null;
        this.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(!unchecking && (checkedId != -1)) {
                super.clicked();
            }
            else {
                unchecking = false;
            }
        });
    }

    public RadioGroup(ArrayList<Integer> datapointIDs, android.widget.RadioGroup radioGroup, UndoStack undoStack) {
        super(0);
        this.radioGroup = radioGroup;
        this.datapointIDs = datapointIDs;
        this.undoStack = undoStack;
        int buttonNumber = radioGroup.getChildCount();
        if(buttonNumber == datapointIDs.size()) {
            for (int i = 0; i < buttonNumber; i++) {
                radioButtons.add(new RadioButton(
                        datapointIDs.get(i),
                        (android.widget.RadioButton) radioGroup.getChildAt(i),
                        undoStack));
            }
        }
        else {
            Log.e(TAG, "Radio group button number doesn't match number of datapoint IDs");
        }
    }

    public void undo(int currSelectedId) {
        radioGroup.check(currSelectedId);
    }

    public void redo(int currSelectedId) {
        radioGroup.check(currSelectedId);
    }

    public void unselect() {
        unchecking = true;
        radioGroup.clearCheck();
    }

    @Override
    public String getValue() {
        if(radioGroup.getCheckedRadioButtonId() == -1) {
            return "None selected";
        }
        else return ((android.widget.RadioButton)radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
    }

    public class RadioButton extends UIElement {
        private final android.widget.RadioButton radioButton;
        private final UndoStack undoStack;
        private RadioButton(int datapointID, android.widget.RadioButton radioButton, UndoStack undoStack) {
            super(datapointID);

            this.radioButton = radioButton;
            this.undoStack = undoStack;
            radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked) {
                    undoStack.addTimestamp(this);
                }
            });
        }

        public void undo(RadioButton currSelected) {
            RadioGroup.this.undo(currSelected.radioButton.getId());
        }

        public void redo(RadioButton currSelected) {
            RadioGroup.this.redo(currSelected.radioButton.getId());
        }

        @Override
        public String getValue() {
            return radioButton.getText().toString();
        }

        @Override
        public boolean getIndependent() {
            return false;
        }
    }

}

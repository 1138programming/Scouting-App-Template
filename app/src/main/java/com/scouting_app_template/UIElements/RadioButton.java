package com.scouting_app_template.UIElements;

public class RadioButton extends UIElement {
    private final android.widget.RadioButton radioButton;
    private final UndoStack undoStack;
    public RadioButton(int datapointID, android.widget.RadioButton radioButton, UndoStack undoStack) {
        super(datapointID);

        this.radioButton = radioButton;
        this.undoStack = undoStack;
        radioButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                undoStack.addTimestamp(this);
            }
        });
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

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

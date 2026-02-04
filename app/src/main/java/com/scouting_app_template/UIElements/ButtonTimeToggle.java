package com.scouting_app_template.UIElements;

import android.content.res.ColorStateList;

import java.util.Objects;

public class ButtonTimeToggle extends UIElement {
    private final android.widget.Button button;
    private final UndoStack undoStack;
    private final int normalColor;
    private final int altColor;
    private boolean colorSwapped = false;

    public ButtonTimeToggle(int datapointID, android.widget.Button button, UndoStack undoStack, int altColor) {
        super(datapointID);
        this.button = button;
        this.undoStack = undoStack;
        normalColor = Objects.requireNonNull(button.getBackgroundTintList()).getDefaultColor();
        this.altColor = altColor;
        this.button.setOnClickListener(View1 -> clicked());
    }

    @Override
    public void clicked() {
        super.clicked();

        swapColors();

        undoStack.addTimestamp(this);
    }

    @Override
    public void undo() {
        swapColors();
    }

    @Override
    public void redo() {
        swapColors();
    }

    @Override
    public boolean getIndependent() {
        return false;
    }

    private void swapColors() {
        colorSwapped = !colorSwapped;
        if (colorSwapped) {
            setColor(altColor);
        }
        else {
            setColor(normalColor);
        }
    }

    private void setColor(int color) {
        button.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    @Override
    public void enable() {
        button.setEnabled(true);
    }

    @Override
    public void disable(boolean override) {
        if(disableable || override) {
            button.setEnabled(false);
        }
    }
}

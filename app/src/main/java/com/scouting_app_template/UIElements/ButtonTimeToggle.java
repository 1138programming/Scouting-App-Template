package com.scouting_app_template.UIElements;

import android.content.res.ColorStateList;

import java.util.Objects;

public class ButtonTimeToggle extends UIElement {
    private final android.widget.Button binding;
    private final UndoStack undoStack;
    private final ColorStateList normalColor;
    private final ColorStateList altColor;
    private boolean colorSwapped = false;

    public ButtonTimeToggle(int datapointID, android.widget.Button binding, UndoStack undoStack, ColorStateList altColor) {
        super(datapointID);
        this.binding = binding;
        this.undoStack = undoStack;
        normalColor = binding.getBackgroundTintList();
        this.altColor = altColor;
        this.binding.setOnClickListener(View1 -> clicked());
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
            binding.setBackgroundTintList(altColor);
        }
        else {
            binding.setBackgroundTintList(normalColor);
        }
    }
}

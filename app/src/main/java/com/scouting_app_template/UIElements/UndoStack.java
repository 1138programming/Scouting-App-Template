package com.scouting_app_template.UIElements;

import static com.scouting_app_template.datapointIDs.ReversedDatapointIDs.reversedDatapointIDs;
import static com.scouting_app_template.MainActivity.TAG;
import static com.scouting_app_template.MainActivity.autonLengthMs;
import static com.scouting_app_template.MainActivity.teleopLengthMs;

import android.util.Log;
import android.widget.Toast;

import com.scouting_app_template.JSON.JSONManager;
import com.scouting_app_template.MainActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;

/**
 *
 */
public class UndoStack {
    private final Stack<UIElement> inputStack = new Stack<>();
    private final Stack<Integer> timestamps = new Stack<>();
    private Stack<UIElement> redoStack = new Stack<>();
    private final Stack<Integer> redoTimestamps = new Stack<>();
    private final HashMap<Integer, UIElement> allElements = new HashMap<>();
    private final MainActivity mainActivity;
    private boolean matchPhaseAuton;

    public UndoStack(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void addElement(UIElement element) {
        allElements.put(element.getID(), element);
    }

    public UIElement getElement(int datapointID) {
        return allElements.get(datapointID);
    }

    public void addTimestamp(UIElement element) {
        if(!allElements.containsKey(element.getID())) {
            addElement(element);
        }

        inputStack.add(element);
        timestamps.add((int) (Calendar.getInstance(Locale.US).getTimeInMillis()-(mainActivity.getCurrStartTime())));
        redoStack = new Stack<>();
    }

    public JSONArray getTimestamps(JSONObject datapointTemplate) {
        JSONManager manager = new JSONManager(datapointTemplate);

        for(UIElement element : inputStack) {
            Log.d(TAG, String.valueOf(element.getID()));
        }

        ArrayList<ButtonTimeToggle> buttonToggleList = new ArrayList<>();
        ArrayList<Integer> toggleStartTimestamps = new ArrayList<>();

        //saves each timestamped datapoint to the JSON
        for(UIElement element : inputStack) {
            if(element instanceof ButtonTimeToggle) {
                if(buttonToggleList.contains(element)) {
                    int index = buttonToggleList.indexOf(element);
                    manager.addDatapoint(buttonToggleList.remove(index).getID(),
                            String.valueOf(Math.abs(timestamps.pop()-toggleStartTimestamps.get(index))),
                            toggleStartTimestamps.remove(index));
                }
                else {
                    buttonToggleList.add((ButtonTimeToggle) element);
                    toggleStartTimestamps.add(timestamps.pop());
                }
            }
            else {
                manager.addDatapoint(element.getID(), element.getValue(), timestamps.pop());
            }
        }
        if(!buttonToggleList.isEmpty()) {
            int periodTimeLength = matchPhaseAuton ? autonLengthMs : teleopLengthMs;
            for(ButtonTimeToggle button : buttonToggleList) {
                int index = buttonToggleList.indexOf(button);
                manager.addDatapoint(button.getID(),
                        String.valueOf((periodTimeLength-toggleStartTimestamps.get(index))),
                        toggleStartTimestamps.get(index));
            }
        }

        //saves each non-timestamped datapoint to the JSON
        for(UIElement element : allElements.values()) {
            if(element.getIndependent()) {
                manager.addDatapoint(element.getID(), element.getValue());
            }
        }
        return manager.getJSON();
    }

    /**
     *
     * @return the top {@link UIElement} in the inputStack
     */
    public UIElement undo() {
        if(inputStack.isEmpty()) return null;

        UIElement element = inputStack.pop();

        element.undo();
        redoStack.push(element);
        redoTimestamps.push(timestamps.pop());
        Toast.makeText(mainActivity, "Undid " + reversedDatapointIDs.get(element.getID()), Toast.LENGTH_SHORT).show();

        return element;
    }

    /**
     *
     * @return the {@link UIElement} that was moved to top of inputStack
     */
    public UIElement redo() {
        if(redoStack.isEmpty()) return null;

        UIElement element = redoStack.pop();

        element.redo();
        inputStack.push(element);
        timestamps.push(redoTimestamps.pop());
        Toast.makeText(mainActivity, "Redid " + reversedDatapointIDs.get(element.getID()), Toast.LENGTH_SHORT).show();

        return element;
    }

    public void setMatchPhaseAuton() {
        matchPhaseAuton = true;
    }

    public void setMatchPhaseTeleop() {
        matchPhaseAuton = false;
    }

    public void disableScouting() {
        for(UIElement element : allElements.values()) {
            element.disable(false);
        }
    }

    public void disableAll() {
        for(UIElement element : allElements.values()) {
            element.disable(true);
        }
    }

    public void enableAll() {
        for(UIElement element : allElements.values()) {
            element.enable();
        }
    }
}

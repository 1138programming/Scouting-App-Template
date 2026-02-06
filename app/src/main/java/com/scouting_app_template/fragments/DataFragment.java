package com.scouting_app_template.fragments;

import androidx.fragment.app.Fragment;

import com.scouting_app_template.MainActivity;
import com.scouting_app_template.UIElements.UndoStack;

import org.json.JSONArray;
import org.json.JSONException;

public class DataFragment extends Fragment {
    protected final UndoStack undoStack;

    public DataFragment() {
        undoStack = new UndoStack((MainActivity)requireActivity());
    }

    public JSONArray getFragmentMatchData() throws JSONException {
        return undoStack.getTimestamps(((MainActivity)requireActivity()).getBaseJSON());

    }
}

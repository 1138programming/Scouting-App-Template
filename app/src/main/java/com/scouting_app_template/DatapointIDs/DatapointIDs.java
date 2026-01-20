package com.scouting_app_template.DatapointIDs;

import java.util.EnumMap;
import java.util.HashMap;

public class DatapointIDs {
    public static final HashMap<Integer, String> reversedDatapointIDs = new HashMap<>();
    public static final EnumMap<DatapointEnum, Integer> datapointIDs = new EnumMap<>(DatapointEnum.class);
    public static final EnumMap<NonDataEnum, Integer> nonDataIDs = new EnumMap<>(NonDataEnum.class);

    static {
        datapointIDs.put(DatapointEnum.confidenceSlider, 1);

        reversedDatapointIDs.put(1, "Robot Start Point String (1, 2, 3, NoShow)");
        reversedDatapointIDs.put(2, "Auton Start");
        reversedDatapointIDs.put(3, "Auton Coral Score L1");
        reversedDatapointIDs.put(4, "Auton Coral Score L2");
        reversedDatapointIDs.put(5, "Auton Coral Score L3");
        reversedDatapointIDs.put(6, "Auton Coral Score L4");
        reversedDatapointIDs.put(7, "Auton Coral Missed L1");
        reversedDatapointIDs.put(8, "Auton Coral Missed L2");
        reversedDatapointIDs.put(9, "Auton Coral Missed L3");
        reversedDatapointIDs.put(10, "Auton Coral Missed L4");
        reversedDatapointIDs.put(11, "Auton Coral Pickup");
        reversedDatapointIDs.put(12, "Auton Algae Removed L2");
        reversedDatapointIDs.put(13, "Auton Algae Removed L3");
        reversedDatapointIDs.put(14, "Auton Algae Removed Failed L2");
        reversedDatapointIDs.put(15, "Auton Algae Removed Failed L3");
        reversedDatapointIDs.put(16, "Auton Net Score");
        reversedDatapointIDs.put(17, "Auton Net Miss");
        reversedDatapointIDs.put(18, "Auton Processor Score");
        reversedDatapointIDs.put(19, "Auton Processor Missed");
        reversedDatapointIDs.put(20, "Leave");
        reversedDatapointIDs.put(21, "Teleop Start");
        reversedDatapointIDs.put(22, "Teleop Coral Score L1");
        reversedDatapointIDs.put(23, "Teleop Coral Score L2");
        reversedDatapointIDs.put(24, "Teleop Coral Score L3");
        reversedDatapointIDs.put(25, "Teleop Coral Score L4");
        reversedDatapointIDs.put(26, "Teleop Coral Missed L1");
        reversedDatapointIDs.put(27, "Teleop Coral Missed L2");
        reversedDatapointIDs.put(28, "Teleop Coral Missed L3");
        reversedDatapointIDs.put(29, "Teleop Coral Missed L4");
        reversedDatapointIDs.put(30, "Teleop Coral Pick up");
        reversedDatapointIDs.put(31, "Teleop Algae Removed L2");
        reversedDatapointIDs.put(32, "Teleop Algae Removed L3");
        reversedDatapointIDs.put(33, "Teleop Algae Removed Failed L2");
        reversedDatapointIDs.put(34, "Teleop Algae Removed Failed L3");
        reversedDatapointIDs.put(35, "Teleop Net Score");
        reversedDatapointIDs.put(36, "Teleop Net Miss");
        reversedDatapointIDs.put(37, "Teleop Processor Score");
        reversedDatapointIDs.put(38, "Teleop Processor Missed");
        reversedDatapointIDs.put(39, "Hang Attempted (boolean)");
        reversedDatapointIDs.put(40, "Hang (String: Park Deep Shallow)");
        reversedDatapointIDs.put(41, "Hang Failed (boolean)");
        reversedDatapointIDs.put(42, "Disconnect (boolean)");
        reversedDatapointIDs.put(43, "Stuck String:(Coral Algae)");
        reversedDatapointIDs.put(44, "Defense Start");
        reversedDatapointIDs.put(45, "Defense End");

        nonDataIDs.put(NonDataEnum.ScouterName, -1);
        nonDataIDs.put(NonDataEnum.MatchNumber, -2);
        nonDataIDs.put(NonDataEnum.TeamColor, -3);
        nonDataIDs.put(NonDataEnum.NoShow, -4);
        nonDataIDs.put(NonDataEnum.StartPosRadio, -5);
        nonDataIDs.put(NonDataEnum.TeamNumber, -6);
        nonDataIDs.put(NonDataEnum.PreAutonNext, -7);
        nonDataIDs.put(NonDataEnum.ArchiveHamburger, -8);
        nonDataIDs.put(NonDataEnum.AutonStartBack, -9);
        nonDataIDs.put(NonDataEnum.AutonStartStart, -10);
        nonDataIDs.put(NonDataEnum.AutonUndo, -11);
        nonDataIDs.put(NonDataEnum.AutonRedo, -12);
        nonDataIDs.put(NonDataEnum.AutonScored, -13);
        nonDataIDs.put(NonDataEnum.AutonMissed, -14);
        nonDataIDs.put(NonDataEnum.AutonBack, -15);
        nonDataIDs.put(NonDataEnum.AutonNext, -16);
        nonDataIDs.put(NonDataEnum.TeleopStartBack, -17);
        nonDataIDs.put(NonDataEnum.TeleopStartStart, -18);
        nonDataIDs.put(NonDataEnum.TeleopUndo, -19);
        nonDataIDs.put(NonDataEnum.TeleopRedo, -20);
        nonDataIDs.put(NonDataEnum.TeleopScored, -21);
        nonDataIDs.put(NonDataEnum.TeleopMissed, -22);
        nonDataIDs.put(NonDataEnum.TeleopBack, -23);
        nonDataIDs.put(NonDataEnum.TeleopNext, -24);
        nonDataIDs.put(NonDataEnum.PostMatchBack, -25);
        nonDataIDs.put(NonDataEnum.PostMatchSubmit, -26);
        nonDataIDs.put(NonDataEnum.ConfirmSubmitCancel, -27);
        nonDataIDs.put(NonDataEnum.ConfirmSubmitSubmit, -28);
        nonDataIDs.put(NonDataEnum.ButtonStack, -29);
        nonDataIDs.put(NonDataEnum.ResetCancel, -30);
        nonDataIDs.put(NonDataEnum.ResetConfirm, -31);
    }
}



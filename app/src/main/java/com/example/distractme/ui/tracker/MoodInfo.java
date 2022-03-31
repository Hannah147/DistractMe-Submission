package com.example.distractme.ui.tracker;

public class MoodInfo {
    String moodEvent;

    public MoodInfo(String moodEvent) {
        this.moodEvent = moodEvent;
    }
    public MoodInfo() {

    }

    public String getMoodEvent() {
        return moodEvent;
    }

    public void setMoodEvent(String moodEvent) {
        this.moodEvent = moodEvent;
    }
}

package com.example.distractme.ui.distractions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DistractionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DistractionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is distractions fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
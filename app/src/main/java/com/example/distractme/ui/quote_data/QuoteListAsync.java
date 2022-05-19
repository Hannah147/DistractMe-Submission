package com.example.distractme.ui.quote_data;

import com.example.distractme.ui.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsync {
    void processFinished(ArrayList<Quote> quotes);

}
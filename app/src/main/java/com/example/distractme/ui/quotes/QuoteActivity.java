package com.example.distractme.ui.quotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.distractme.R;
import com.example.distractme.ui.model.Quote;
import com.example.distractme.ui.other_resources.quote_fragment;
import com.example.distractme.ui.quote_data.QuoteAdapter;
import com.example.distractme.ui.quote_data.QuoteData;
import com.example.distractme.ui.quote_data.QuoteListAsync;

import java.util.ArrayList;
import java.util.List;

public class QuoteActivity extends AppCompatActivity {

    private QuoteAdapter quoteAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        quoteAdapter = new QuoteAdapter(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteAdapter);

    }
    private List<Fragment> getFragments(){
        final List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsync() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for(int i = 0; i < quotes.size(); i++){
                    quote_fragment quoteFragment = quote_fragment.newInstance(
                            quotes.get(i).getText(),
                            quotes.get(i).getAuthor());

                    fragmentList.add(quoteFragment);
                }

                quoteAdapter.notifyDataSetChanged();
            }
        });

        return fragmentList;
    }
}


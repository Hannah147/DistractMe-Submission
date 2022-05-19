package com.example.distractme.ui.other_resources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.distractme.R;

import java.util.concurrent.ThreadLocalRandom;

public class quote_fragment extends Fragment {


    public quote_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[] {R.color.logo_blue_transparent, R.color.logo_green_transparent, R.color.logo_purple_transparent, R.color.logo_yellow_transparent,
        R.color.logo_blue_transparent_2, R.color.logo_green_transparent_2, R.color.logo_purple_transparent_2, R.color.logo_yellow_transparent_2};

        quoteText.setText(quote);
        byAuthor.setText("-" + author);

        cardView.setBackgroundResource(getRandomQuoteColor(colors));

        return quoteView;
    }

    public static final com.example.distractme.ui.other_resources.quote_fragment newInstance(String quote, String author){
        com.example.distractme.ui.other_resources.quote_fragment fragment = new com.example.distractme.ui.other_resources.quote_fragment();
        Bundle bundle = new Bundle();

        bundle.putString("quote", quote);
        bundle.putString("author", author);

        fragment.setArguments(bundle);

        return fragment;
    }

    int getRandomQuoteColor(int colorArray[]){

        int color;
        int quotesArrayLen = colorArray.length;

        int rand = ThreadLocalRandom.current().nextInt(quotesArrayLen);

        color = colorArray[rand];

        return color;
    }

}

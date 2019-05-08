package com.example.user.sudoku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images = {
            R.drawable.slidehistory,
            R.drawable.sliderules,
            R.drawable.slidekota
    };

    public String[] slide_headings = {
            "Sudoku History",
            "Sudoku Rules",
            "Kota Morinishi"
    };

    public String[] slide_descs = {
            "On July 6, 1895, Le Siècle's rival, La France, refined the puzzle so that it was almost a modern Sudoku. It simplified the 9×9 magic square puzzle so that each row, column, and broken diagonals contained only the numbers 1–9, but did not mark the subsquares. Although they are unmarked, each 3×3 subsquare does indeed comprise the numbers 1–9 and the additional constraint on the broken diagonals leads to only one solution, The modern Sudoku was most likely designed anonymously by Howard",
            "Each puzzle consists of a 9x9 grid containing given clues in various places. The object is to fill all empty squares so that the numbers 1 to 9 appear exactly once in each row, column and 3x3 box.",
            "Kota Morinishi finally beat out nearly 180 other competitors from 34 countries to win the World Sudoku Championship held in London. Mr. Morinishi is the first Japanese to win the tournament and bring the title to the country where sudoku, the numerical puzzle featuring a 9-by-9 grid, was popularized in the 1980s."
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.activity_slide_layout,container,false);

        ImageView slideImageView= view.findViewById(R.id.slideImage);
        TextView slideHeading=  view.findViewById(R.id.slideHeading);
        TextView slideDescription= view.findViewById(R.id.slideDesc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}

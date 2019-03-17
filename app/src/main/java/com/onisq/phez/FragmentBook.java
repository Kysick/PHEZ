package com.onisq.phez;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentBook   extends Fragment {

    View v;
    private RecyclerView myrecycleview;
    private List<Theme> lstTheme;

    public FragmentBook() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_book, container, false);
        myrecycleview = (RecyclerView) v.findViewById(R.id.book_recyclerview);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),lstTheme);
        myrecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(recyclerAdapter);
        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lstTheme = new ArrayList<>();
        lstTheme.add(new Theme("Кинематика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Динамика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Законы сохранения", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Статика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Колебания и волны", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Молекурлярная физика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Термодинамика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Электричество", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Электрический ток ", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Магнетизм", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Электромагнетизм", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Волновая оптика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Геометрическая оптика", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Теория относительности", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Световые кванты", R.drawable.ic_insert_emoticon_black_24dp));
        lstTheme.add(new Theme("Атомное ядро", R.drawable.ic_insert_emoticon_black_24dp));
    }
}

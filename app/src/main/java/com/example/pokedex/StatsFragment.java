package com.example.pokedex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String POKEMON_STATS = "pokemon_stats";


    // TODO: Rename and change types of parameters


    public StatsFragment() {
        // Required empty public constructor
    }


    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putParcelable(POKEMON_STATS, pokemonStats);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        TextView hpTextView = (TextView) view.findViewById(R.id.fragment_stat_hp);
        TextView attackTextView = (TextView) view.findViewById(R.id.fragment_stat_attack);
        TextView defenseTextView = (TextView) view.findViewById(R.id.fragment_stat_defense);
        TextView speedTextView = (TextView) view.findViewById(R.id.fragment_stat_speed);
        if(getArguments() != null)
        {
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS);
            hpTextView.setText(pokemonStats.getHp());
            attackTextView.setText(pokemonStats.getAttack());
            defenseTextView.setText(pokemonStats.getDefense());
            speedTextView.setText(pokemonStats.getSpeed());
        }
        return view;
    }
}
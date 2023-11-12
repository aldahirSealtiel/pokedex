package com.example.pokedex;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    public PokemonListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        ListView pokemonListView = (ListView) view.findViewById(R.id.pokemon_listView);


        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        Stats bulbasaurStats = new Stats("45", "49", "49", "65");
        Stats ivysaur = new Stats("60", "62", "49", "65");
        Stats venuasaur = new Stats("80", "82", "49", "65");
        Stats charmander = new Stats("39", "52", "49", "65");
        Stats charmeleon = new Stats("58", "64", "49", "65");
        Stats charizard = new Stats("78", "84", "49", "65");
        Stats squirtle = new Stats("44", "48", "49", "65");
        Stats wartortle = new Stats("59", "63", "49", "65");
        Stats blastoise = new Stats("79", "83", "49", "65");
        Stats pikachu = new Stats("35", "55", "49", "50");
        Stats raichu = new Stats("60", "85", "50", "85");

        pokemonList.add(new Pokemon("1", "Bulbasaur" , R.drawable.bulbasaur,R.raw.bulbasaur , Pokemon.Type.PLANT, bulbasaurStats));
        pokemonList.add(new Pokemon("2", "Ivysaur" , R.drawable.ivysaur, R.raw.ivysaur,Pokemon.Type.PLANT, ivysaur));
        pokemonList.add(new Pokemon("3", "Venuasaur", R.drawable.venusaur, R.raw.venusaur ,Pokemon.Type.PLANT, venuasaur));
        pokemonList.add(new Pokemon("4", "Charmander", R.drawable.charmander, R.raw.charmander ,Pokemon.Type.FIRE, charmander));
        pokemonList.add(new Pokemon("5", "Charmeleon", R.drawable.charmeleon, R.raw.charmeleon ,Pokemon.Type.FIRE, charmeleon));
        pokemonList.add(new Pokemon("6", "Charizard" , R.drawable.charizard, R.raw.charizard,Pokemon.Type.FIRE, charizard));
        pokemonList.add(new Pokemon("7", "Squirtle", R.drawable.squirtle, R.raw.squirtle ,Pokemon.Type.WATER, squirtle));
        pokemonList.add(new Pokemon("8", "Wartortle", R.drawable.wartortle, R.raw.wartortle ,Pokemon.Type.WATER, wartortle));
        pokemonList.add(new Pokemon("9", "Blastoise", R.drawable.blastoise, R.raw.blastoise ,Pokemon.Type.WATER, blastoise));
        pokemonList.add(new Pokemon("25", "Pikachu", R.drawable.pikachu, R.raw.pikachu ,Pokemon.Type.ELECTRIC, pikachu));
        pokemonList.add(new Pokemon("26", "Raichu", R.drawable.raichu, R.raw.raichu ,Pokemon.Type.ELECTRIC, raichu));

        final PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), R.layout.pokemon_list_item, pokemonList);
        pokemonListView.setAdapter(adapter);

        pokemonListView.setOnItemClickListener( new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Pokemon selectedPokemon = adapter.getItem(position);
                if(selectedPokemon != null)
                {
                    //Toast.makeText(getActivity(), selectedPokemon.getName(), Toast.LENGTH_SHORT).show();
                    mListener.onPokemonSelected(selectedPokemon);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString() +
                    " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener{

        void onPokemonSelected(Pokemon pokemon);

    }
}
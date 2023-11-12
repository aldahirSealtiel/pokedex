package com.example.pokedex;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private static final String POKEMON_IMAGE_URL = "pokemon_image_url";
    private static final String POKEMON_SOUND_ID = "pokemon_sound_id";
    private ImageView detailImageView;


    private OnFragmentInteractionListener mListener;
    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(int pokemonImageUrl, int pokemonSoundId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(POKEMON_IMAGE_URL, pokemonImageUrl);
        args.putInt(POKEMON_SOUND_ID, pokemonSoundId);
        fragment.setArguments(args);
        return fragment;
    }



    private void setPokemonImage(int pokemonImageId)
    {
        detailImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), pokemonImageId));
    }

    private void playPokemonSound(int pokemonSoundId)
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), pokemonSoundId);
        mediaPlayer.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailImageView = (ImageView) view.findViewById(R.id.pokemon_detail_imageView);
        if(getArguments() != null)
        {
            int pokemonImageUrl = getArguments().getInt(POKEMON_IMAGE_URL);
            int pokemonSoundId = getArguments().getInt(POKEMON_SOUND_ID);
            setPokemonImage(pokemonImageUrl);
            playPokemonSound(pokemonSoundId);
        }
        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
          throw new RuntimeException(context.toString()
            + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }

}
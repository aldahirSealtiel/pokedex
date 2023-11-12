package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements PokemonListFragment.OnFragmentInteractionListener,
DetailFragment.OnFragmentInteractionListener, View.OnClickListener{

    private static final int OPTION_DETAIL = 0;
    private static final int OPTION_STATS = 1;
    private TextView imageTextView;
    private TextView statsTextView;

    private int selectedOption;
    private Pokemon selectedPokemon;

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageTextView = (TextView) findViewById(R.id.activity_main_image_option_textView);
        statsTextView = (TextView) findViewById(R.id.activity_main_stats_option_textView);

        imageTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_options_selected));
        statsTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_options_not_selected));

        imageTextView.setOnClickListener(this);
        statsTextView.setOnClickListener(this);
    }


    @Override
    public void onPokemonSelected(Pokemon pokemon) {
        //Toast.makeText(this, pokemon.getName(), Toast.LENGTH_SHORT).show();
        //Se cambio debido a que ahora se creará el fragmento dinamicamente
        // DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        selectedPokemon = pokemon;
        setFragmentAndContent();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        if (viewId == R.id.activity_main_image_option_textView)
        {
            imageTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_options_selected));
            statsTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_options_not_selected));
            selectedOption = OPTION_DETAIL;
        }
        else if(viewId == R.id.activity_main_stats_option_textView)
        {
            imageTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_options_not_selected));
            statsTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.display_options_selected));
            selectedOption = OPTION_STATS;
        }
        setFragmentAndContent();
    }

    private void setFragmentAndContent(){
        if(selectedPokemon != null)
        {
            if(selectedOption == OPTION_DETAIL)
            {
                currentFragment = DetailFragment.newInstance(selectedPokemon.getImageId(), selectedPokemon.getSoundId());
            }
            else if(selectedOption == OPTION_STATS)
            {
                currentFragment = StatsFragment.newInstance(selectedPokemon.getStats());
            }
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            //nos permite cambiar el contenido del fragmento a mostrar
            fragmentTransaction.replace(R.id.detail_fragment_container, currentFragment);
            //se usa el commit para que se realice la acción
            fragmentTransaction.commit();
        }
        else
        {
            Toast.makeText(this, "Debes seleccionar un pokemón primero", Toast.LENGTH_SHORT).show();
        }
    }
}
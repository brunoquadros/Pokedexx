package br.com.ceduphh.bruno.pokedex;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PokedexActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Pokemon[] pokemons = {
                new Pokemon("Charizard", 7,"Flame Pokémon","5′7″ (1.70m)",  "199.5 lbs (90.5 kg)", "Blaze","Solar Power", "", Type.FIRE, Type.FLYING),
                new Pokemon("Blastoise", 9,"Shellfish Pokémon","5′3″ (1.60m)","188.5 lbs (85.5 kg)","Torrent","Rain Dish","", Type.WATER, null),
                new Pokemon("Tentacruel", 73,"Jellyfish Pokémon","5′3″ (1.60m)","121.3 lbs (55.0 kg)","Clear Body","Liquid Ooze","Rain Dish", Type.WATER, Type.POISON),
                new Pokemon("Magneton", 82,"Magnet Pokémon","3′3″ (0.99m)","132.3 lbs (60.0 kg)","Magnet Pull","Sturdy","Analytic", Type.ELECTRIC, Type.STEEL),
                new Pokemon("Ariados", 168,"Long Leg Pokémon","3′7″ (1.09m)","73.9 lbs (33.5 kg)","Insomnia","Swarm","Sniper", Type.BUG, Type.POISON),
                new Pokemon("Murkrow", 198,"Darkness Pokémon","1′8″ (0.51m)","4.6 lbs (2.1 kg","Insomnia","Super Luck","Prankster", Type.DARK, Type.FLYING),
                new Pokemon("Magcargo", 219,"Lava Pokémon","2′7″ (0.79m)","121.3 lbs (55.0 kg)","Flame Body","Magma Armor","Weak Armor", Type.FIRE, Type.ROCK),
        };

        PokedexAdapter adapter = new PokedexAdapter(this, pokemons);
        setListAdapter(adapter);


    }

    private class PokedexAdapter extends ArrayAdapter<Pokemon> {

        private PokedexAdapter(Context context, Pokemon[] objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View inflatedView = layoutInflater.inflate(R.layout.pokemon_list_layout, null);

            ImageView imageView = (ImageView) inflatedView.findViewById(R.id.image);
            imageView.setFocusable(false);

            TextView numberTextView = (TextView) inflatedView.findViewById(R.id.number);
            numberTextView.setFocusable(false);

            TextView nameTextView = (TextView) inflatedView.findViewById(R.id.name);
            nameTextView.setFocusable(false);

            TextView primaryTypeTextView = (TextView) inflatedView.findViewById(R.id.primaryType);


            TextView secondaryTypeTextView = (TextView) inflatedView.findViewById(R.id.secondaryType);


            Pokemon pokemon = getItem(position);

            String formatedNumber = String.format("%03d", pokemon.getNationalNumber());

            nameTextView.setText(pokemon.getName());
            numberTextView.setText("(#" + formatedNumber + ")");

            int imageId = getResources().getIdentifier("sprite_" + formatedNumber, "drawable", getPackageName());
            imageView.setImageResource(imageId);

            configureForType(primaryTypeTextView, pokemon.getPrimaryType());
            configureForType(secondaryTypeTextView, pokemon.getSecondaryType());

            return inflatedView;
        }

        private void configureForType(TextView textView, Type type) {
            if (type == null) {
                textView.setVisibility(View.GONE);
            } else {
                int backgroundResource = getResources().getIdentifier("type_" + type.name().toLowerCase(), "drawable", getPackageName());
                int textResource = getResources().getIdentifier("type_" + type.name().toLowerCase(), "string", getPackageName());

                textView.setBackgroundResource(backgroundResource);
                textView.setText(textResource);
            }
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Pokemon pokemon = (Pokemon) l.getAdapter().getItem(position);
        Intent intent = new Intent(PokedexActivity.this, PokemonDetails.class);
        intent.putExtra("Pokemon",pokemon);
        startActivity(intent);
    }
}

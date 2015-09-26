package br.com.ceduphh.bruno.pokedex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class PokemonDetails extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        final Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("Pokemon");
        TextView speciesTextView = (TextView) findViewById(R.id.species);
        speciesTextView.setText(pokemon.getSpecies());
        TextView heightTextView = (TextView) findViewById(R.id.height);
        heightTextView.setText(pokemon.getHeight());
        TextView weightTextView = (TextView) findViewById(R.id.weight);
        weightTextView.setText(pokemon.getWeight());
        TextView abilitiesTextView = (TextView) findViewById(R.id.abilities);
        abilitiesTextView.setText(pokemon.getAbilities1());
        TextView abilities2TextView = (TextView) findViewById(R.id.abilities2);
        abilities2TextView.setText(pokemon.getAbilities2());
        TextView abilities3TextView = (TextView) findViewById(R.id.abilities3);
        abilities3TextView.setText(pokemon.getAbilities3());

        ImageView imageView = (ImageView) findViewById(R.id.imageDetailsView);
        if (pokemon.getName().equals("Charizard")) {
            imageView.setImageResource(R.drawable.sprite_007);
        } else if (pokemon.getName().equals("Blastoise")) {
            imageView.setImageResource(R.drawable.sprite_009);
        } else if (pokemon.getName().equals("Tentacruel")) {
            imageView.setImageResource(R.drawable.sprite_073);
        } else if (pokemon.getName().equals("Magneton")) {
            imageView.setImageResource(R.drawable.sprite_082);
        } else if (pokemon.getName().equals("Ariados")) {
            imageView.setImageResource(R.drawable.sprite_168);
        } else if (pokemon.getName().equals("Murkrow")) {
            imageView.setImageResource(R.drawable.sprite_198);
        } else if (pokemon.getName().equals("Magcargo")) {
            imageView.setImageResource(R.drawable.sprite_219);
        }
    }

        /*@Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.pokemons_details, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }*/

}
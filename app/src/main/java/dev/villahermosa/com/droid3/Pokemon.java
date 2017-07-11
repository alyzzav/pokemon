package dev.villahermosa.com.droid3;

/**
 * Created by Villahermosa on 7/6/2017.
 */

public class Pokemon {


    private String pokemonName;
    private String pokemonURL;

    public Pokemon() {

    }

    public Pokemon(String pokemonName, String pokemonURL) {
        this.pokemonName = pokemonName;
        this.pokemonURL = pokemonURL;
    }

    public String getPokemonImageURL() {
        return pokemonURL;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void pokemonURL(String pokemonURL) {
        this.pokemonURL = pokemonURL;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}

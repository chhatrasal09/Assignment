package chhatrasal.app.com.redcarpetassignment.javaClass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chhatrasal on 31/7/17.
 */

public class CountryPopulation {

    @SerializedName("rank")
    private Integer rank;

    @SerializedName("country")
    private String country;

    @SerializedName("population")
    private String population;

    @SerializedName("flag")
    private String imageUrl;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return " CountryPopulation { " +
                "'rank' = " + rank  +
                ", 'country' = '" + country + '\'' +
                ", 'population' = '" + population +'\'' +
                ", 'flag' = '" + imageUrl + '}';
    }
}

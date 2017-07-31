package chhatrasal.app.com.redcarpetassignment.javaClass;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chhatrasal on 31/7/17.
 */

public class RxJavaResponse {

    @SerializedName("worldpopulation")
    private List<CountryPopulation> worldPopulation;

    public List<CountryPopulation> getWorldPopulation() {
        return worldPopulation;
    }

    public void setWorldPopulation(List<CountryPopulation> worldPopulation) {
        this.worldPopulation = worldPopulation;
    }

    @Override
    public String toString() {
        return " RxJavaResponse { " +
                "'worldpopulation' = " + worldPopulation + " } ";
    }
}

package br.org.fundatec.dogwalkerapp;

/**
 * Created by tecnico on 28/11/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dog {
    @SerializedName("imgDog")
    @Expose
    public String imgDog;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("carrier")
    @Expose
    public String carrier;

    @SerializedName("descriptionDog")
    @Expose
    public String descriptionDog;


}

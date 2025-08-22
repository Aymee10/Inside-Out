package dev.aymee.dto;
import com.google.gson.annotations.SerializedName;

import dev.aymee.dto.value_object.ShortInfoVO;


public class MovieDTO {

    private String imdbId;

    @SerializedName("short")
    private ShortInfoVO shortInfo;

    public String getImdbId() {
        return imdbId;
    }

    public ShortInfoVO getShortInfo() {
        return shortInfo;
    }

}

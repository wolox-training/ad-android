package ar.com.wolox.android.example.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 */
public class User implements Serializable {

   @SerializedName("id") private int id;
   @SerializedName("username") private String username;
   @SerializedName("email") private String email;
   @SerializedName("password") private String password;
   @SerializedName("picture") private String picture;
   @SerializedName("cover") private String cover;
   @SerializedName("description") private String description;
   @SerializedName("location") private String location;
   @SerializedName("name") private String name;
   @SerializedName("phone") private String phone;

    public int getId() {
        return id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @Nullable
    public String getPicture() {
        return picture;
    }

    @Nullable
    public String getCover() {
        return cover;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public String getLocation() {
        return location;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }
}
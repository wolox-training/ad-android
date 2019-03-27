package ar.com.wolox.android.example.model;

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

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return picture;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
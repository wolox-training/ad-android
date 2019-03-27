package ar.com.wolox.android.example.network;

import ar.com.wolox.android.example.model.User;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;

/**
 *
 */
public interface UserService {

    @GET("/users/{email}")
    Call<User> getUserByEmail(@Path("email") String email);
}

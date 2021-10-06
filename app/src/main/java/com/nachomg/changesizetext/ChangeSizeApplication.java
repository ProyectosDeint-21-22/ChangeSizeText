package com.nachomg.changesizetext;

import android.app.Application;

import com.nachomg.changesizetext.model.User;

/**
 * Clase que sobreescribe la clase Application, porque queremos que esta clase sea global en toda
 * la aplicación y que se vea en todas las Activitys.
 */
public class ChangeSizeApplication extends Application {
    private User user;
    @Override
    public void onCreate() {
        super.onCreate();
        user= new User("Nacho","nachomogo@gmail.com");
    }

    public User getUser() {
        return user;
    }
}

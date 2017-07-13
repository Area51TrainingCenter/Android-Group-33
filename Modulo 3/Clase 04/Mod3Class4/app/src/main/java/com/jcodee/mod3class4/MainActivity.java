package com.jcodee.mod3class4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TwitterLoginButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        try {
            //Validamos que la app este instalada
            getPackageManager()
                    .getPackageInfo("com.twitter.android", PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "Twitter no está instalado", Toast.LENGTH_LONG).show();
        }

        btnLogin = (TwitterLoginButton) findViewById(R.id.btnLogin);
        btnLogin.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                Call<User> userCall =
                        TwitterCore.getInstance().getApiClient()
                                .getAccountService().verifyCredentials(false, false, false);
                userCall.enqueue(new retrofit2.Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });

                Toast.makeText(MainActivity.this, "->" + result.data.getUserName() + " - " + result.data.getUserId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        btnLogin.onActivityResult(requestCode, resultCode, data);
    }
}

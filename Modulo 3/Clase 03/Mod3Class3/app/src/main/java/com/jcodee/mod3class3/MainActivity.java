package com.jcodee.mod3class3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    private TextView tvNombre, tvApellido, tvFecha, tvCorreo;
    private SimpleDraweeView sdvImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        Fresco.initialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvApellido = (TextView) findViewById(R.id.tvApellido);
        tvFecha = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        sdvImagen = (SimpleDraweeView) findViewById(R.id.sdvImagen);

        loginButton = (LoginButton) findViewById(R.id.btnFacebook);
        //Solicitamos permisos que vamos a pedirle al usuario
        loginButton.setReadPermissions("email", "public_profile", "user_friends", "user_birthday");

        //Creamos una variable la cual va a retornar la información
        callbackManager = CallbackManager.Factory.create();
        //Creamos un evento el cual va a escuchar cuando facebook devuelva datos después de
        //realizar alguna acción con el boton
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code

                                String nombre = object.optString("first_name");
                                String apellido = object.optString("last_name");
                                String correo = object.optString("email");
                                String birthday = object.optString("birthday");
                                String id = object.optString("id");

                                tvNombre.setText(nombre);
                                tvApellido.setText(apellido);
                                tvCorreo.setText(correo);
                                tvFecha.setText(birthday);
                                sdvImagen.setImageURI(
                                        Uri.parse("https://graph.facebook.com/" + id + "/picture?type=large"));

                                Log.d("TAG", object.toString());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,email,first_name,last_name,birthday");
                request.setParameters(parameters);
                request.executeAsync();

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Los datos devueltos por facebook son obtenidos y notificados al register
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

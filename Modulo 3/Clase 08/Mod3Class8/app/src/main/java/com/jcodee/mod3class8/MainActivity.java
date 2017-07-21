package com.jcodee.mod3class8;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodee.mod3class8.modelos.Alternativas;
import com.jcodee.mod3class8.modelos.Preguntas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout contenedor = (LinearLayout) findViewById(R.id.contenedor);
        for (final Preguntas item : cargarDatos()) {

            TextView textView = new TextView(MainActivity.this);
            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(params);
            textView.setText(item.getDescripcion());
            textView.setTextColor(Color.BLACK);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,
                            "Pregunta-> " + item.getDescripcion(),
                            Toast.LENGTH_SHORT).show();
                }
            });

            contenedor.addView(textView);

            if (item.getAlternativas() != null) {
                RadioGroup radioGroup = new RadioGroup(MainActivity.this);
                LinearLayout.LayoutParams radioGroupParams =
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
                radioGroup.setLayoutParams(radioGroupParams);

                for (Alternativas elem : item.getAlternativas()) {

                    RadioButton radioButton = new RadioButton(MainActivity.this);
                    LinearLayout.LayoutParams radioParams =
                            new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT);
                    radioButton.setLayoutParams(radioParams);
                    radioButton.setText(elem.getDescripcion());
                    radioGroup.addView(radioButton);

                }
                contenedor.addView(radioGroup);
            }

        }


    }

    private ArrayList<Preguntas> cargarDatos() {
        ArrayList<Preguntas> preguntas = new ArrayList<>();

        Preguntas preguntas1 = new Preguntas();
        preguntas1.setId(1);
        preguntas1.setDescripcion("Pregunta 1");

        ArrayList<Alternativas> alternativas1 = new ArrayList<>();
        Alternativas alternativas = new Alternativas();
        alternativas.setId(1);
        alternativas.setDescripcion("Descripción 1");
        alternativas1.add(alternativas);

        Alternativas alternativas2 = new Alternativas();
        alternativas2.setId(2);
        alternativas2.setDescripcion("Descripción 2");
        alternativas1.add(alternativas2);

        Alternativas alternativas3 = new Alternativas();
        alternativas3.setId(3);
        alternativas3.setDescripcion("Descripción 3");
        alternativas1.add(alternativas3);

        preguntas1.setAlternativas(alternativas1);

        preguntas.add(preguntas1);

        Preguntas preguntas2 = new Preguntas();
        preguntas2.setId(2);
        preguntas2.setDescripcion("Pregunta 2");

        preguntas.add(preguntas2);

        return preguntas;
    }
}

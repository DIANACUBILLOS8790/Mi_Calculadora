package dyana.android.mi_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {


    TextView resultado, Total;
    Button Cero,Uno, Dos, Tres, Cuatro, Cinco, Seis, Siete, Ocho, Nueve, Punto, Sumar, Restar, Multiplicar, Dividir, Porcentaje, Parentesis;

    boolean Bracket = false;
    String Proceso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Inicial();


    }


    public void Inicial() {
        resultado = findViewById(R.id.Proceso);
        Total = findViewById(R.id.Resultado);

        Cero = findViewById(R.id.Cero);
        Uno = findViewById(R.id.Uno);
        Dos = findViewById(R.id.Dos);
        Tres = findViewById(R.id.Tres);
        Cuatro = findViewById(R.id.Cuatro);
        Cinco = findViewById(R.id.Cinco);
        Seis = findViewById(R.id.Seis);
        Siete = findViewById(R.id.Siete);
        Ocho = findViewById(R.id.Ocho);
        Nueve = findViewById(R.id.Nueve);


        Sumar = findViewById(R.id.Sumar);
        Multiplicar = findViewById(R.id.Multiplicar);
        Dividir = findViewById(R.id.Dividir);
        Restar = findViewById(R.id.Restar);
        Punto = findViewById(R.id.Punto);
        Porcentaje = findViewById(R.id.Porcenaje);
        Parentesis = findViewById(R.id.Parentesis);


        Cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "0");
            }

        });


        Uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "1");
            }


        });

        Dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "2");
            }


        });

        Tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "3");
            }
        });


        Cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "4");
            }
        });


        Cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "5");
            }
        });


        Seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "6");
            }
        });


        Siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "7");
            }
        });


        Ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "8");
            }
        });


        Nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "9");
            }
        });


        Sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "+");
            }
        });


        Multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "*");
            }
        });


        Dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "/");
            }
        });

        Restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "-");
            }

        });


        Porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + "%");
            }
        });


        Punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proceso = resultado.getText().toString();
                resultado.setText(Proceso + ".");
            }
        });

        Parentesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Bracket){
                    Proceso = resultado.getText().toString();
                    resultado.setText(Proceso + ")");
                    Bracket = false;
                }else {
                    Proceso = resultado.getText().toString();
                    resultado.setText(Proceso + "(");
                    Bracket =true;
                }

            }
        });

    }


    public void Igual(View view) {

        Proceso = resultado.getText().toString();
        Proceso = Proceso.replaceAll("x", "*");
        Proceso = Proceso.replaceAll("%", "/100");

        Context context = Context.enter();
        context.setOptimizationLevel(-1);

        String finalResultado = "";

        try {
            Scriptable scriptable = context.initSafeStandardObjects();
            finalResultado = context.evaluateString(scriptable, Proceso, "javascript", 1, null).toString();


        } catch (Exception e) {
            finalResultado = "0";

        }
        Total.setText(finalResultado);

    }


    public void Limpiar(View view) {

        resultado.setText("");
        Total.setText("");
    }


    public void Borrar(View view) {

        String string = resultado.getText().toString();

        if (string.length() >= 1) {

            string = string.substring(0, string.length() - 1);
            resultado.setText(string);
        }else if (string.length() < 1) {
                 resultado.setText("");
        }

    }

}
package com.example.first_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    Button btnResetta;
    Button btnTest;
    Button btnLancia;
    TextView lblTesto; //Non è il plain ma quello statico
    EditText lblEditabile;
    public static final String EXTRA_MESSAGE = "com.example.first_activity.extra.MESSAGE";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // instanzia tutti gli oggetti, attribuisco una vista, esiste file xml che è nostra vista ma non dico quali oggetti ci sono
        mMessageEditText = findViewById(R.id.InserisciNome);

        btnResetta= (Button) findViewById(R.id.reset);   //Recupero il riferimento in memoria di quello id --> restituisce la vista
        //vista: è il contenitore generale utilizzato dal sistema android
        btnTest= (Button) findViewById(R.id.test);
        //il cast usato perchè ci sono molti altri linguaggi che non fanno il cast implicito, x abituarci.
        btnLancia=(Button) findViewById(R.id.play);
        lblTesto= (TextView) findViewById(R.id.nomeStatico);
        lblEditabile=(EditText) findViewById(R.id.InserisciNome);



    }

    public void resetta (View v)
    {
        lblEditabile.setText("");
    }

    public void test(View v) //firma, bisogna passargli l'oggetto in cui deve stare in ascolto
    {
        Toast t=Toast.makeText(getApplicationContext(),"Hai cliccato il tasto TEST", Toast.LENGTH_LONG);
        //Tosat per il movimento da l'alto verso il basso, Serve per mandare msg a video (alert) x comunicare a utente
        //Toast classe astratta, non posso invocare metodo su di essa.
        t.show();
    }

    public void lanciaSeconda(View view)
    {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this,SecondActivity.class);
        String message = mMessageEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        //i.putExtra("etichetta", lblTesto.getText()); //Per mettere in memoria a Intent un name, che contine il testo lblTesto
        //etichetta è la chiave associativa
        startActivity(intent);
    }




}
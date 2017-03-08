package br.com.fiap.exemplofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class ExemploFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_file);
    }

    public void criar(View view) {
        try {
            FileOutputStream fos = openFileOutput("Teste.txt",MODE_PRIVATE);
            String texto = "Bom Dia !";
            fos.write(texto.getBytes());
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ler(View view) {
        try {
            FileInputStream fis = openFileInput("Teste.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String texto = br.readLine();
            fis.close();
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

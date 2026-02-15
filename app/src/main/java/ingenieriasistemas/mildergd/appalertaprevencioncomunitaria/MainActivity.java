package ingenieriasistemas.mildergd.appalertaprevencioncomunitaria;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.Toast;

import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.db.Repositorio;
import ingenieriasistemas.mildergd.appalertaprevencioncomunitaria.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private Repositorio repositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }



}
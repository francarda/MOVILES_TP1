package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.tp1.databinding.ActivityMainBinding;
import com.example.tp1.databinding.ActivityTraduccionBinding;

public class TraduccionActivity extends AppCompatActivity {
    private TraduccionActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityTraduccionBinding binding= ActivityTraduccionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccionActivityViewModel.class);
        Intent intent= getIntent();
        String p=(String) intent.getStringExtra("texto");

        mv.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra pal) {
               binding.traduccion.setText(pal.getIngles());
               binding.imImagen.setImageResource(pal.getFoto());

            }
        });
        mv.comparar(p);

    }
}
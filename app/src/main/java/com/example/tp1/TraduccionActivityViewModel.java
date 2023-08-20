package com.example.tp1;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TraduccionActivityViewModel extends AndroidViewModel {
    private List<Palabra> lista=new ArrayList<>();
    private Palabra error = new Palabra("error", "no se encontro", R.drawable.error);


    private Context context;
    private MutableLiveData<Palabra> traducido;

    public TraduccionActivityViewModel(@NonNull Application application) {
        super(application);

        this.context= application.getApplicationContext();
        lista.add(new Palabra("gato","cat",R.drawable.gato));
        lista.add(new Palabra("perro", "dog", R.drawable.perro));
        lista.add(new Palabra("casa", "house", R.drawable.casa));
        lista.add(new Palabra("auto","car", R.drawable.auto));
        lista.add(new Palabra("bicicleta", "bike", R.drawable.bicicleta));

    }
    public void comparar(String texto){
        traducido.setValue(error);
        for (Palabra palabra:lista
             ) {if (palabra.getCastellano().equals(texto)){
                 traducido.setValue(palabra);
             }

        }
    }
    public LiveData<Palabra> getPalabraM() {

        if (traducido == null) {

            traducido = new MutableLiveData<Palabra>();
        }
        return traducido;
    }
}


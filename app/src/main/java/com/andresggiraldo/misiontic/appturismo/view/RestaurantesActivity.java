package com.andresggiraldo.misiontic.appturismo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.andresggiraldo.misiontic.appturismo.R;
import com.andresggiraldo.misiontic.appturismo.adapter.AdapterRestaurantes;
import com.andresggiraldo.misiontic.appturismo.model.Restaurantes;

import java.util.ArrayList;

public class RestaurantesActivity extends AppCompatActivity {

    AdapterRestaurantes adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        RecyclerView recycleRestaurantes=findViewById(R.id.rest_recycle);
        recycleRestaurantes.setLayoutManager(new GridLayoutManager(this,2));

        adapter=new AdapterRestaurantes();
        recycleRestaurantes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        llenarRestaurantes();
    }

    private void llenarRestaurantes() {
        ArrayList<Restaurantes> listaRestaurantes = new ArrayList<>();
        listaRestaurantes.add(new Restaurantes("Restautante",R.drawable.restaurant1));
        listaRestaurantes.add(new Restaurantes("Restautante1",R.drawable.restaurant2));
        listaRestaurantes.add(new Restaurantes("Restautante2",R.drawable.restaurant3));
        listaRestaurantes.add(new Restaurantes("Restautante3",R.drawable.restaurant4));
        listaRestaurantes.add(new Restaurantes("Restautante4",R.drawable.restaurant5));
        listaRestaurantes.add(new Restaurantes("Restautante5",R.drawable.restaurant1));
        listaRestaurantes.add(new Restaurantes("Restautante6",R.drawable.restaurant2));
        listaRestaurantes.add(new Restaurantes("Restautante7",R.drawable.restaurant3));
        listaRestaurantes.add(new Restaurantes("Restautante8",R.drawable.restaurant4));
        listaRestaurantes.add(new Restaurantes("Restautante9",R.drawable.restaurant2));


        adapter.setData(listaRestaurantes);
    }
}
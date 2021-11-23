package com.andresggiraldo.misiontic.appturismo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.andresggiraldo.misiontic.appturismo.R;
import com.andresggiraldo.misiontic.appturismo.adapter.MainRecyclerAdapter;
import com.andresggiraldo.misiontic.appturismo.model.AllCategory;
import com.andresggiraldo.misiontic.appturismo.model.CategoryItem;


import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements MainRecyclerAdapter.Listener {

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Se agregan algunos datos para nuestra clase model

        //datos agregados categoria1
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, R.drawable.masvisit1));
        categoryItemList.add(new CategoryItem(1, R.drawable.masvisit2));
        categoryItemList.add(new CategoryItem(1, R.drawable.masvisit3));
        categoryItemList.add(new CategoryItem(1, R.drawable.masvisit4));
        categoryItemList.add(new CategoryItem(1, R.drawable.masvisit5));

        //datos agregados categoria2
        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(1, R.drawable.hotel1));
        categoryItemList2.add(new CategoryItem(1, R.drawable.hotel2));
        categoryItemList2.add(new CategoryItem(1, R.drawable.hotel3));
        categoryItemList2.add(new CategoryItem(1, R.drawable.hotel4));
        categoryItemList2.add(new CategoryItem(1, R.drawable.hotel5));

        //datos agregados categoria3
        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(1, R.drawable.restaurant1));
        categoryItemList3.add(new CategoryItem(1, R.drawable.restaurant2));
        categoryItemList3.add(new CategoryItem(1, R.drawable.restaurant3));
        categoryItemList3.add(new CategoryItem(1, R.drawable.restaurant4));
        categoryItemList3.add(new CategoryItem(1, R.drawable.restaurant5));

        //datos agregados categoria4
        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        categoryItemList4.add(new CategoryItem(1, R.drawable.masvisit1));
        categoryItemList4.add(new CategoryItem(1, R.drawable.masvisit2));
        categoryItemList4.add(new CategoryItem(1, R.drawable.masvisit3));
        categoryItemList4.add(new CategoryItem(1, R.drawable.masvisit4));
        categoryItemList4.add(new CategoryItem(1, R.drawable.masvisit5));

        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Mas Visitados", categoryItemList));
        allCategoryList.add(new AllCategory("Hoteles", categoryItemList2));
        allCategoryList.add(new AllCategory("Restaurantes", categoryItemList3));
        allCategoryList.add(new AllCategory("Actividades", categoryItemList4));

        setMainCategoryRecycler(allCategoryList);
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){

        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList,this);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }


    @Override
    public void itemClick(AllCategory item) {
        switch (item.getCategoryTitle()){
            case "Mas Visitados":
                Log.e(HomeActivity.class.getName(),"Espacio para hacer el TODO de mas visitados");
                break;
            case "Hoteles":
                Log.e(HomeActivity.class.getName(),"Espacio para hacer el TODO hoteles");
                break;
            case "Restaurantes":
                Intent intent = new Intent( this, RestaurantesActivity.class);
                startActivity(intent);
                break;
            case "Actividades":
                Log.e(HomeActivity.class.getName(),"Espacio para hacer el TODO de las actividades");
                break;
        }
    }
}
package com.andresggiraldo.misiontic.appturismo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andresggiraldo.misiontic.appturismo.R;
import com.andresggiraldo.misiontic.appturismo.model.Restaurantes;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterRestaurantes extends RecyclerView.Adapter<AdapterRestaurantes.ViewHolderRestaurantes>{

    ArrayList<Restaurantes> listaRestaurantes;

    public AdapterRestaurantes() {
        this.listaRestaurantes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderRestaurantes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderRestaurantes(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_restaurantes,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRestaurantes holder, int position) {
        holder.itemNombre.setText(listaRestaurantes.get(position).getNombre());
        //holder.item_grid_imagen

        Glide.with(holder.itemView.getContext())
                .load(listaRestaurantes.get(position).getFoto())
                .centerCrop()
                .into(holder.itemGridImagen);
    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(ArrayList<Restaurantes> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
        notifyDataSetChanged();
    }

    public class ViewHolderRestaurantes extends RecyclerView.ViewHolder {

        TextView itemNombre;
        ImageView itemGridImagen;

        public ViewHolderRestaurantes(@NonNull View itemView) {
            super(itemView);
            itemNombre=itemView.findViewById(R.id.item_nombre);
            itemGridImagen=(ImageView) itemView.findViewById(R.id.item_grid_imagen);
        }

    }
}



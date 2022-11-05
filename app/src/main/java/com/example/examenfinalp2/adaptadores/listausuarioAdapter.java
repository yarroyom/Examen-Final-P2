package com.example.examenfinalp2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinalp2.R;

import java.util.ArrayList;

import Entidades.usuarios;

public class listausuarioAdapter extends RecyclerView.Adapter<listausuarioAdapter.usuarioviewHolder> {

    ArrayList<usuarios> listaUsuarios;
    public listausuarioAdapter(ArrayList<usuarios>listaUsuarios){
        this.listaUsuarios=listaUsuarios;
    }

    @NonNull
    @Override
    public usuarioviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuario,null,false);
    return  new usuarioviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull usuarioviewHolder holder, int position) {
holder.viewusuario.setText(listaUsuarios.get(position).getUsuario());
        holder.viewusuario.setText(listaUsuarios.get(position).getPassword_t());

    }

    @Override
    public int getItemCount() {
       return listaUsuarios.size();
    }


    public class usuarioviewHolder extends RecyclerView.ViewHolder {
        TextView viewusuario, viewpassword;

        public usuarioviewHolder(@NonNull View itemView) {
            super(itemView);
            viewusuario= itemView.findViewById(R.id.viewusuario);
            viewusuario= itemView.findViewById(R.id.viewpassword);
        }
    }
}


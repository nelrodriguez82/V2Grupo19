package com.example.ofertasenamap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ofertasenamap.conexion.DbProgramas;

import java.util.List;

public class AdapterProgramas extends RecyclerView.Adapter<AdapterProgramas.ViewHolderProgramas>{
    List<ListProgramas> listProgramas;
    FragmentActivity context;

    public AdapterProgramas(List<ListProgramas> listProgramas, FragmentActivity context) {
        this.listProgramas = listProgramas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderProgramas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_programas, null, false);
        return new ViewHolderProgramas(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProgramas holder, int position) {
        holder.asignarProgramas(listProgramas.get(position));
    }

    @Override
    public int getItemCount() {
        return listProgramas.size();
    }

    public class ViewHolderProgramas extends RecyclerView.ViewHolder {

        TextView nombrep;
        TextView codigop;
        TextView duracion;

        Button btnEdit;
        Button btnRemove;
        FragmentActivity context;

        public ViewHolderProgramas(@NonNull View itemView, FragmentActivity context) {
            super(itemView);
            nombrep = itemView.findViewById(R.id.nombre);
            codigop = itemView.findViewById(R.id.codigo);
            duracion = itemView.findViewById(R.id.duracion);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            this.context = context;
        }

        public void asignarProgramas(ListProgramas a) {
            nombrep.setText(a.getNombre().trim());
            codigop.setText(Integer.toString(a.getCodigo()).trim());
            duracion.setText(a.getDuracion().trim());

            btnEdit.setOnClickListener(view -> ((CardsItems) context).switchWindow(new com.example.ofertasenamap.ActualizarPrograma(a)));
            btnRemove.setOnClickListener(view -> {
                DbProgramas c = new DbProgramas(context);
                Dialogo d = new Dialogo(context,"Advertencia","¿Esta seguro de eliminar el programa?", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        c.eliminarPrograma(Integer.toString(a.getCodigo()));
                        Toast.makeText(context, "Se ha eliminado: " + a.getNombre(), Toast.LENGTH_SHORT).show();
                        c.close();
                        ((CardsItems) context).switchWindow(new VerProgramas());
                    }
                });

                ((CardsItems) context).switchWindow(new VerProgramas());
            });
        }
    }
}



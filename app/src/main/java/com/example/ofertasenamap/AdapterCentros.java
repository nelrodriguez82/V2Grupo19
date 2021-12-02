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

import com.example.ofertasenamap.conexion.DbCentros;

import java.util.List;

public class AdapterCentros extends RecyclerView.Adapter<AdapterCentros.ViewHolderCentros>{
    List<ListCentros> listCentros;
    FragmentActivity context;

    public AdapterCentros(List<ListCentros> listCentros, FragmentActivity context) {
        this.listCentros = listCentros;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterCentros.ViewHolderCentros onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_centros, null, false);
        return new AdapterCentros.ViewHolderCentros(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCentros.ViewHolderCentros holder, int position) {
        holder.asignarCentros(listCentros.get(position));
    }

    @Override
    public int getItemCount() {
        return listCentros.size();
    }

    public class ViewHolderCentros extends RecyclerView.ViewHolder {

        TextView nombrep;
        TextView codigop;


        Button btnEdit;
        Button btnRemove;
        FragmentActivity context;

        public ViewHolderCentros(@NonNull View itemView, FragmentActivity context) {
            super(itemView);
            nombrep = itemView.findViewById(R.id.nombre);
            codigop = itemView.findViewById(R.id.codigo);


            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnRemove = itemView.findViewById(R.id.btnRemove);
            this.context = context;
        }

        public void asignarCentros(ListCentros a) {
            nombrep.setText(a.getNombre().trim());
            codigop.setText(Integer.toString(a.getCodigo()).trim());


            btnEdit.setOnClickListener(view -> ((CentrosItems) context).switchWindow(new com.example.ofertasenamap.ActualizarCentro(a)));
            btnRemove.setOnClickListener(view -> {
                DbCentros c = new DbCentros(context);
                Dialogo d = new Dialogo(context,"Advertencia","¿Esta seguro de eliminar el Centro?", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        c.eliminarCentro(Integer.toString(a.getCodigo()));
                        Toast.makeText(context, "Se ha eliminado: " + a.getNombre(), Toast.LENGTH_SHORT).show();
                        c.close();
                        ((CentrosItems) context).switchWindow(new VerCentros());
                    }
                });

                ((CentrosItems) context).switchWindow(new VerCentros());
            });
        }
    }
}



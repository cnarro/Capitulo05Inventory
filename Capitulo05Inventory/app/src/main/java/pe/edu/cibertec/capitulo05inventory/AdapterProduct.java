package pe.edu.cibertec.capitulo05inventory;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductPrototype> {
    @NonNull

    ArrayList<Product> items;

    public AdapterProduct(@NonNull ArrayList<Product> items) {
        this.items = items;
    }

    //Crea la vista en base el prototipo por cada celda
    public ProductPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        //Se crea una vista y se "infla" o inicializa el layout creado para el prototipo
        View  view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_product,viewGroup, false);
        ProductPrototype productPrototype = new ProductPrototype(view);
        return productPrototype;
    }

    //Carga la información por cada celda de acuerdo a la posición
    @Override
    public void onBindViewHolder(@NonNull ProductPrototype productPrototype, int position) {
        productPrototype.tvName.setText(items.get(position).getName());
        productPrototype.tvDescription.setText(items.get(position).getDescription());
        productPrototype.tvQuantity.setText(String.valueOf(items.get(position).getQuantity()));
    }

    //Indica la cantidad de registros que se van a mostrar en el Recycler View
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ProductPrototype extends RecyclerView.ViewHolder {

        TextView tvName, tvDescription, tvQuantity;

        public ProductPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}

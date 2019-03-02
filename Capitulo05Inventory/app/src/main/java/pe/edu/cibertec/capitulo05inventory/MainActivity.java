package pe.edu.cibertec.capitulo05inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Vista
    RecyclerView rvProduct;

    //Modelo: Información a mostrar
    ArrayList<Product> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlaza variale con su lista a partir del id
        rvProduct = findViewById(R.id.rvProduct);

        //Asigna espacio en memoria para el arreglo
        items = new ArrayList<>();

        //Adaptador
        AdapterProduct adapterProduct;

        //Cargar la información a mostrar
        loadItems();

        //Inicializar el Adaptador
        adapterProduct = new AdapterProduct(items);

        //Decirle al Recycler view cuál es su Adapter
        rvProduct.setAdapter(adapterProduct);

        rvProduct.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadItems() {
        //Instancia un objeto de la clase Producto
        Product productLaptop = new Product("Laptop", "Marca Toshiba", 2);
        //Agrega el objeto creado a la lista
        items.add(productLaptop);

        Product productMouse = new Product("Mouse", "Modelo Genious", 122);
        items.add(productMouse);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,ProductActivity.class);
        startActivity(intent);
        return true;
    }
}

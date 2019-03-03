package pe.edu.cibertec.capitulo05inventory;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ProductActivity extends AppCompatActivity {

    TextInputEditText etName, etDescription, etQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etQuantity = findViewById(R.id.etQuantity);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.product_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String name = etName.getText().toString();
        String description = etDescription.getText().toString();
        int quantity = Integer.parseInt(etQuantity.getText().toString());
        //Product product = new Product(name, description, quantity);

        //Pasamos los valores a través del intent
        Intent intent = getIntent();
        intent.putExtra("product_name", name);
        intent.putExtra("product_description", description);
        intent.putExtra("product_quantity", quantity);

        //Definimos el código del resultado a la operación realizada y pasamos el intent para que
        // sepa cuál es la información que va retornar
        setResult(RESULT_OK, intent);
        finish();

        return true;
    }
}

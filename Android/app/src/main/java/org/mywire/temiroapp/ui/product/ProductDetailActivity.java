package org.mywire.temiroapp.ui.product;


import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.prefs.ConfigAPI;
import org.mywire.temiroapp.model.Product;
import org.mywire.temiroapp.data.remote.ProductService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductDetailActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productPrice, productDescription, productDetalle;

    private Button buyButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);

        String productUrl = getIntent().getStringExtra("productUrl");

        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        productDescription = findViewById(R.id.productDescription);
        productDetalle = findViewById(R.id.productDetalle);
        buyButton = findViewById(R.id.button);


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí inicia la actividad de pago
                Intent intent = new Intent(ProductDetailActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });

        if (productUrl != null) {
            // Aquí puedes realizar la llamada a Retrofit utilizando la URL del producto
            Retrofit retrofit = new Retrofit.Builder()

                    .baseUrl(productUrl) // Usar la URL del producto como base URL

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ProductService productService = retrofit.create(ProductService.class);
            Call<Product> call = productService.getProductByUrl(productUrl);
            call.enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> response) {
                    if (response.isSuccessful()) {
                        Product product = response.body();

                        productName.setText(product.getDescripcion());
                        productPrice.setText("Precio: $" + product.getPrecio());
                        productDescription.setText(product.getEspecificaciones());
                        productDetalle.setText(product.getDetalle());

                        Glide.with(ProductDetailActivity.this)
                                .load(product.getImagen())
                                .apply(new RequestOptions()
                                        .placeholder(R.drawable.ic_launcher_background)
                                        .error(R.drawable.ic_launcher_background)
                                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                                .into(productImage);
                    } else {
                        Toast.makeText(ProductDetailActivity.this, "Error al cargar los detalles del producto", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Product> call, Throwable t) {
                    // Mensaje de error genérico
                    String errorMessage = "Error de red";

                    // Verificar si la excepción tiene un mensaje
                    if (t != null && t.getMessage() != null) {
                        errorMessage = "Error de red: " + t.getMessage();
                    }

                    // Mostrar el mensaje de error
                    Toast.makeText(ProductDetailActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(ProductDetailActivity.this, "URL de producto incorrecta!", Toast.LENGTH_LONG).show();
        }
    }
}

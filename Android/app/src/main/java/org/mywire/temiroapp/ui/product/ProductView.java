package org.mywire.temiroapp.ui.product;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.mywire.temiroapp.data.prefs.ConfigAPI;
import org.mywire.temiroapp.R;
import org.mywire.temiroapp.data.remote.ProductService;
import org.mywire.temiroapp.model.Product;
import java.util.List;

public class ProductView extends Fragment {


    private ProductService productService;
    //  private String UbicacionAPI = ConfigAPI.webapi_URL + ":" + ConfigAPI.webapi_PORT + "/";

    // Lista de URLs de productos
    private static final String[] PRODUCT_URLS = {
            "https://django-auth-crud-hvkm.onrender.com/lentes-de-lectura/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-deportivos/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-de-natacion/",
            "https://django-auth-crud-hvkm.onrender.com/gafas-de-proteccion/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-de-ninos/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-de-tendencia/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-multifocales/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-bluefilter/",
            "https://django-auth-crud-hvkm.onrender.com/lentes-para-lejos/"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product_ppal, container, false);


        // Configuración de los botones
        for (int i = 0; i < PRODUCT_URLS.length; i++) {
            Button button = rootView.findViewById(getResources().getIdentifier("btnproduct" + (i + 1), "id", getActivity().getPackageName()));
            final String productUrl = PRODUCT_URLS[i];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startProductDetailActivity(productUrl);
                }
            });
        }


        return rootView;
    }

    private void startProductDetailActivity(String productUrl) {
        if (productUrl != null && !productUrl.isEmpty()) {
            Intent intent = new Intent(getActivity(), ProductDetailActivity.class);
            intent.putExtra("productUrl", productUrl);
            startActivity(intent);
        } else {
            Log.e("ProductView", "URL de producto nula o vacía");
        }
    }

}
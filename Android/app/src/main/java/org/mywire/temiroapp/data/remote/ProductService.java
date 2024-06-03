package org.mywire.temiroapp.data.remote;

import org.mywire.temiroapp.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import java.util.List;

public interface ProductService {

    @GET("webapi/producto")
    Call<List<Product>> getProducts();

    @GET("webapi/producto/{productId}")
    Call<Product> getProductById(@Path("productId") int productId);

    @GET("webapi/{url}")
    Call<Product> getProductByUrl(@Path("url") String url);

}

package org.mywire.temiroapp.data.remote;

import org.mywire.temiroapp.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

import java.util.List;

import java.util.List;

public interface ProductService {

    @GET("webapi/producto")
    Call<List<Product>> getProducts();

    @GET("webapi/producto/{productId}")
    Call<Product> getProductById(@Path("productId") int productId);

    @GET
    Call<Product> getProductByUrl(@Url String url);
}
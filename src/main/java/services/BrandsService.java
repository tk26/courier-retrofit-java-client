package services;

import models.Brand;
import models.BrandCreateBody;
import models.BrandUpdateBody;
import models.Brands;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class BrandsService {
    private final BrandsInterface brandsInterface;

    public BrandsService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.courier.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        brandsInterface = retrofit.create(BrandsInterface.class);
    }

    public Brands getBrands(
            String token
    ) throws IOException {
        return brandsInterface.getBrands(
                "Bearer " + token
        ).execute().body();
    }

    public Brand getBrand(
            String brandId,
            String token
    ) throws IOException {
        return brandsInterface.getBrand(
                brandId,
                "Bearer " + token
        ).execute().body();
    }

    public Brand postBrand(
            BrandCreateBody brand,
            String token
    ) throws IOException {
        return brandsInterface.postBrand(
                brand,
                "Bearer " + token
        ).execute().body();
    }

    public Brand putBrand(
            String brandId,
            BrandUpdateBody brand,
            String token
    ) throws IOException {
        return brandsInterface.putBrand(
                brandId,
                brand,
                "Bearer " + token
        ).execute().body();
    }

    public Void deleteBrand(
            String brandId,
            String token
    ) throws IOException {
        return brandsInterface.deleteBrand(
                brandId,
                "Bearer " + token
        ).execute().body();
    }
}

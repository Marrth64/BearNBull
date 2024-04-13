package com.example.project;

import com.squareup.moshi.Json;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/cryptocurrency/listings/latest")
    @Headers("X-CMC_PRO_API_KEY: 2117c145-947c-4cd2-8dc5-8935f0fa648c")
    Call<Data> getInvestmentData(
            @Query("start") int start,
            @Query("limit") int limit,
            @Query("convert") String convert
    );
    @GET("v1/cryptocurrency/listings/latest")
    Call<Data> getInvestmentData(
            @Query("start") int start,
            @Query("limit") int limit,
            @Query("convert") String convert,
            @Query("CMC_PRO_API_KEY") String api
    );
    record Data(
            @Json(name = "data.id") String id,
            @Json(name = "root/data/name") String name,
            @Json(name = "root/data/symbol") String symbol,
            @Json(name = "root/data/quote/USD/price") String price,
            @Json(name = "root/data/quote/USD/volume_24h") String volume_24h,
            @Json(name = "root/data/quote/USD/market_cap") String market_cap) {
        @Override
        public String toString() {
            return "Data[" +
                    "id=" + id + ", " +
                    "name=" + name + ", " +
                    "symbol=" + symbol + ", " +
                    "price=" + price + ", " +
                    "volume_24h=" + volume_24h + ", " +
                    "market_cap=" + market_cap + ']';
        }

    }
}


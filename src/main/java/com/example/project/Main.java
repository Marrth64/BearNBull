package com.example.project;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.io.IOException;
// https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=1&convert=USD&CMC_PRO_API_KEY=2117c145-947c-4cd2-8dc5-8935f0fa648c
public class Main {
    public static void main(String[] args) {
        // Create a Moshi instance
        Moshi moshi = new Moshi.Builder().build();

        // Create a Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pro-api.coinmarketcap.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();


        // Create an instance of the ApiService interface
        ApiService apiService = retrofit.create(ApiService.class);

        try {
            // Make the API call
            Response<ApiService.Data> response = apiService.getInvestmentData(1, 1, "USD").execute();
            String url = apiService.getInvestmentData(1, 1, "USD","2117c145-947c-4cd2-8dc5-8935f0fa648c").request().url().toString();
            System.out.println("URL: " + url );
            // Check if the response is successful
            if (response.isSuccessful()) {
                // Get the Data object from the response
                ApiService.Data investments = response.body();
                if (investments != null) {
                    System.out.println(investments.toString());

                } else {
                    System.out.println("No investment data received.");
                }
            } else {
                System.out.println("API call failed. Response code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
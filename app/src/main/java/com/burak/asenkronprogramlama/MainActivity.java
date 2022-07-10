package com.burak.asenkronprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.facebook.shimmer.ShimmerFrameLayout;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asenkron programlama
        //büyük ölçekli işlemlerin uygulamadan bağımsız olarak arkaplanda yapılıp, hazır olunca
        // ekrana yansıtmamızı sağlayan özellik

        // asenkron işlem yaparken 3 metot vardır
        // 1. işlemlerden önce çalışan metot yapısı örn: yükleniyor yazısı çıkar
        // 2. işlem yapmakla sorumlu olan metot
        // 3. işlem yapıldıktan sonra çalışan metot yapısı örn: genellikle bu metotta progresbar kapanır

        new AsenkronCalis().execute();
    }

    private class AsenkronCalis extends AsyncTask<Void, Void, Void>{
        ShimmerFrameLayout face = findViewById(R.id.facebookShimmer);
        // ana işlemden önceki metot 1.
        @Override
        protected void onPreExecute(){
            face.startShimmerAnimation();
        }

        // 2. çalışan metot
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i<999999999;i++){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused){
            face.stopShimmerAnimation();
            face.setVisibility(View.GONE);
        }
    }
}
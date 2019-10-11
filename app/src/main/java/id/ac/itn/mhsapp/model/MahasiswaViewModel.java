package id.ac.itn.mhsapp.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.ac.itn.mhsapp.api.Api;
import id.ac.itn.mhsapp.api.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MahasiswaViewModel extends ViewModel {
    private static final String TAG = "MahasiswaViewModel";

    private MutableLiveData<List<Mahasiswa>> mhsList;

    public LiveData<List<Mahasiswa>> getListMhs(){
        if(mhsList==null){
            mhsList = new MutableLiveData<List<Mahasiswa>>();
            loadMhs();
            Log.d(TAG, "getListMhs: mhs null panggil loadMhs()");
        }
        return mhsList;
    }

    private void loadMhs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Mahasiswa>> call = api.getListMahasiswa(1);

        Log.d(TAG, "loadMhs: " + retrofit.baseUrl());

        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {

                //finally we are setting the list to our MutableLiveData
                mhsList.setValue(response.body());
                Log.d(TAG, "onResponse: Input data ke mhsList");
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                Log.d(TAG, "onFailure: Terjadi kesalahan saat mengambil data " + t.getMessage());
            }
        });
    }
}

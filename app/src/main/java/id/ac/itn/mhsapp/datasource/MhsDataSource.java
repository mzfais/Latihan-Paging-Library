package id.ac.itn.mhsapp.datasource;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

import id.ac.itn.mhsapp.api.ApiClient;
import id.ac.itn.mhsapp.model.Mahasiswa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MhsDataSource extends PageKeyedDataSource<Integer, Mahasiswa> {

    private static final String TAG = "MhsDataSource";
    public static final int PAGE_SIZE = 4;
    public static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Mahasiswa> callback) {
        ApiClient.getInstance().getApi().getListMahasiswa(FIRST_PAGE)
                .enqueue(new Callback<List<Mahasiswa>>() {
                    @Override
                    public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body(), null, FIRST_PAGE + 1);
                            Log.d(TAG, "onResponse: LoadInitial " + response.body().size() + " data");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                            Log.d(TAG, "onFailure: LoadInitial " + t.getMessage());
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Mahasiswa> callback) {
        ApiClient.getInstance().getApi()
                .getListMahasiswa(params.key)
                .enqueue(new Callback<List<Mahasiswa>>() {
                    @Override
                    public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                        Integer key = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
                            callback.onResult(response.body(), key);
                            Log.d(TAG, "onResponse: loadBefore " + key);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                        Log.d(TAG, "onFailure: LoadBefore " + t.getMessage());
                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Mahasiswa> callback) {
        ApiClient.getInstance().getApi()
                .getListMahasiswa(params.key)
                .enqueue(new Callback<List<Mahasiswa>>() {
                    @Override
                    public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body(), params.key + 1);
                            Log.d(TAG, "onResponse: loadAfter " + params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                        Log.d(TAG, "onFailure: LoadAfter " + t.getMessage());
                    }
                });
    }
}

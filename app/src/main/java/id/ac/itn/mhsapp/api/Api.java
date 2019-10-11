package id.ac.itn.mhsapp.api;

import java.util.List;

import id.ac.itn.mhsapp.model.Mahasiswa;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    static final String BASE_URL = "http://192.168.100.12/mhs-api/index.php/api/";

    @GET("mahasiswa")
    Call<List<Mahasiswa>> getListMahasiswa(@Query("page") int page);
}

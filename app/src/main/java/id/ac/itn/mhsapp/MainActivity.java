package id.ac.itn.mhsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import id.ac.itn.mhsapp.adapter.MahasiswaAdapter;
import id.ac.itn.mhsapp.adapter.MhsPagedAdapter;
import id.ac.itn.mhsapp.model.Mahasiswa;
import id.ac.itn.mhsapp.model.MahasiswaViewModel;
import id.ac.itn.mhsapp.model.MhsViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    MhsPagedAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true); // jika recyclerview height wrap_content, maka set false;
        //baca https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html#setHasFixedSize(boolean)
        // jika perubahan data pada adapter tidak berpengaruh terhadap ukuran recyclerview, maka set true

        MhsViewModel mhsViewModel = ViewModelProviders.of(this).get(MhsViewModel.class);
        adapter = new MhsPagedAdapter(this);
        mhsViewModel.mhsPagedList.observe(this, new Observer<PagedList<Mahasiswa>>() {
            @Override
            public void onChanged(PagedList<Mahasiswa> mahasiswas) {
                adapter.submitList(mahasiswas);
                Log.d(TAG, "onChanged: mhsViewModel oberserver submit to adapter");
            }
        });
        recyclerView.setAdapter(adapter);
    }
}

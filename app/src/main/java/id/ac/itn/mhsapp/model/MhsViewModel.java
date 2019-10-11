package id.ac.itn.mhsapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import id.ac.itn.mhsapp.datasource.MhsDataSource;
import id.ac.itn.mhsapp.datasource.MhsDataSourceFactory;

public class MhsViewModel extends ViewModel {
    public LiveData<PagedList<Mahasiswa>> mhsPagedList;
    public LiveData<PageKeyedDataSource<Integer,Mahasiswa>> livedataSource;

    public MhsViewModel(){
        MhsDataSourceFactory mhsDataSourceFactory = new MhsDataSourceFactory();
        livedataSource = mhsDataSourceFactory.getMhsLiveDataSource();

        PagedList.Config config =
                new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(MhsDataSource.PAGE_SIZE)
                .build();
        mhsPagedList = new LivePagedListBuilder(mhsDataSourceFactory,config).build();

    }
}

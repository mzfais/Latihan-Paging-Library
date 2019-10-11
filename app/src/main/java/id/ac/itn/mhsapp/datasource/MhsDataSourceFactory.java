package id.ac.itn.mhsapp.datasource;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import id.ac.itn.mhsapp.model.Mahasiswa;

public class MhsDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Mahasiswa>> mhsLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        MhsDataSource mhsDataSource = new MhsDataSource();
        mhsLiveDataSource.postValue(mhsDataSource);
        return mhsDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Mahasiswa>> getMhsLiveDataSource() {
        return mhsLiveDataSource;
    }
}

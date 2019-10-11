package id.ac.itn.mhsapp.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("nim")
    private String nim;

    @SerializedName("nama")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("jk")
    private String jk;

    public Mahasiswa(String nim, String nama, String alamat, String jk) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
        this.jk = jk;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
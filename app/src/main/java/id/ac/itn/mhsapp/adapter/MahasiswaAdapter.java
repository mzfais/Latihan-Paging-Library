package id.ac.itn.mhsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.itn.mhsapp.R;
import id.ac.itn.mhsapp.model.Mahasiswa;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MhsViewHolder> {

    Context mCtx;
    List<Mahasiswa> mhsList;

    public MahasiswaAdapter(Context mCtx, List<Mahasiswa> mhsList) {
        this.mCtx = mCtx;
        this.mhsList = mhsList;
    }

    @NonNull
    @Override
    public MhsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.mhs_list_item, parent, false);
        return new MhsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsViewHolder holder, int position) {
        Mahasiswa mhs = mhsList.get(position);
        holder.tvnim.setText(mhs.getNim());
        holder.tvnama.setText(mhs.getNama());
    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }

    public class MhsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvnim, tvnama;

        public MhsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnim = itemView.findViewById(R.id.tvNim);
            tvnama = itemView.findViewById(R.id.tvNama);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(mCtx,"Mhs: " + mhsList.get(position).getAlamat(),Toast.LENGTH_SHORT).show();
        }
    }
}

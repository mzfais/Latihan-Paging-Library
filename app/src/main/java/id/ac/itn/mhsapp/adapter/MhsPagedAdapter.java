package id.ac.itn.mhsapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.itn.mhsapp.R;
import id.ac.itn.mhsapp.model.Mahasiswa;

public class MhsPagedAdapter extends PagedListAdapter<Mahasiswa, MhsPagedAdapter.MhsViewHolder> {
    private static final String TAG = "MhsPagedAdapter";
    private Context mCtx;

    public MhsPagedAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public MhsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx)
                .inflate(R.layout.mhs_list_item, parent, false);
        Log.d(TAG, "onCreateViewHolder: seharusnya tampak");
        return new MhsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MhsViewHolder holder, int position) {
        Mahasiswa mhs = getItem(position);
        Log.d(TAG, "onBindViewHolder: tampilkan " + mhs.getNim());
        if (mhs != null) {
            holder.tvnim.setText(mhs.getNim());
            holder.tvnama.setText(mhs.getNama());
        } else {
            Toast.makeText(mCtx, "Data Mahasiswa tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    private static DiffUtil.ItemCallback<Mahasiswa> DIFF_CALLBACK = new DiffUtil.ItemCallback<Mahasiswa>() {
        @Override
        public boolean areItemsTheSame(@NonNull Mahasiswa oldItem, @NonNull Mahasiswa newItem) {
            return oldItem.getNim() == newItem.getNim();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Mahasiswa oldItem, @NonNull Mahasiswa newItem) {
            return oldItem == newItem;
        }
    };

    class MhsViewHolder extends RecyclerView.ViewHolder {
        TextView tvnim, tvnama;

        MhsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnim = itemView.findViewById(R.id.tvNim);
            tvnama = itemView.findViewById(R.id.tvNama);
        }
    }
}

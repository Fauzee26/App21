package fauzi.hilmy.app21;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Online> onlines;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Online> getOnlines() {
        return onlines;
    }

    public void setOnlines(ArrayList<Online> onlines) {
        this.onlines = onlines;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, final int position) {
        Picasso.with(context)
                .load(getOnlines().get(position).getGambar())
                .resize(1200, 1200)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IntentWeb.class);
                intent.putExtra(IntentWeb.EXTRA_NAME, getOnlines().get(position).getNama());
                intent.putExtra(IntentWeb.EXTRA_LINK, getOnlines().get(position).getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getOnlines().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagee);
        }
    }
}

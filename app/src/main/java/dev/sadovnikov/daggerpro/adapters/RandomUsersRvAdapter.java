package dev.sadovnikov.daggerpro.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dev.sadovnikov.daggerpro.MainActivity;
import dev.sadovnikov.daggerpro.R;
import dev.sadovnikov.daggerpro.model.Result;


public class RandomUsersRvAdapter extends RecyclerView.Adapter<RandomUsersRvAdapter.RandomUsersViewHolder> {
    private List<Result> resultList = new ArrayList<>();

    Context context;
    Picasso picasso;

    public RandomUsersRvAdapter(Context context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }


    @NonNull
    @Override
    public RandomUsersRvAdapter.RandomUsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_random_user,
                viewGroup, false);
        return new RandomUsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomUsersRvAdapter.RandomUsersViewHolder randomUsersViewHolder, int position) {
        Result result = resultList.get(position);
        randomUsersViewHolder.textView.setText(String.format("%s %s", result.getName().getFirst(),
                result.getName().getLast()));
        picasso.load(result.getPicture().getLarge()).into(randomUsersViewHolder.imageView);
//        Picasso.with(randomUsersViewHolder.imageView.getContext())
//                .load(result.getPicture().getLarge())
//                .into(randomUsersViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setItems(List<Result> results) {
        resultList = results;
        notifyDataSetChanged();
    }

    class RandomUsersViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        RandomUsersViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.image);
        }


    }
}

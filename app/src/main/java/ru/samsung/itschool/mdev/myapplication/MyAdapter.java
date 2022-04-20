package ru.samsung.itschool.mdev.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.samsung.itschool.mdev.myapplication.model.Anekdot;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {

    private ArrayList<Anekdot> anekdots;

    public MyAdapter(ArrayList<Anekdot> anekdots) {
        this.anekdots = anekdots;
    }

    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new ViewRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, int position) {
        holder.tv.setText(anekdots.get(position).getElementPureHtml());
    }

    @Override
    public int getItemCount() {
        return anekdots.size();
    }

    class ViewRow extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
        }
    }


}

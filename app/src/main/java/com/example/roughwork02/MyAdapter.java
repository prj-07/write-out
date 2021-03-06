package com.example.roughwork02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    Context context;
    CheckBox check;
    ArrayList<UserHelperClass>list;
    List<String>listall;
   private ReccylerViewInterface reccylerViewInterface;


    public MyAdapter(Context context, ArrayList<UserHelperClass> list) {
        this.context = context;
        this.list = list;
       this.reccylerViewInterface  = reccylerViewInterface;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    UserHelperClass user = list.get(position);


      //  FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String currentuser = user.getUid();
       // final String postkey = getRef()



        holder.name.setText(user.getName());
    holder.article.setText(user.getTopic());
    holder.category.setText(user.getCategory());
    holder.date.setText(user.getDate());

    check.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (check.isChecked()){

            }
        }
    });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredlist = new ArrayList<>();

            if(charSequence.toString().isEmpty()){
                filteredlist.addAll(listall);
            }
            else{
                for (String doc:listall){
                    if (doc.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredlist.add(doc);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredlist;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((Collection<? extends UserHelperClass>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,category,article,date;
        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.tvfirstName);
            article = itemView.findViewById(R.id.tvarticle);
            category = itemView.findViewById(R.id.tvcategory);
            date = itemView.findViewById(R.id.tvdate);
            checkBox =itemView.findViewById(R.id.checkBox);

          /*  checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkBox.isChecked())
                    {

                    }


                }


            });
*/

        }
    }
}

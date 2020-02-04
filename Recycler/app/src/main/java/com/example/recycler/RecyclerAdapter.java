package com.example.recycler;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by jb on 06/12/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private Context context;
    private List<User> itemlist;
    public RecyclerAdapter(Context context,List<User> itemlist) {
        this.context = context;
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.navitem,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        //10
        final User u = itemlist.get(position);
        holder.tid.setText(String.valueOf(position+1));
        holder.tname.setText(u.getName());
        holder.tphone.setText(u.getPhone());
        holder.tmail.setText(u.getEmail());
        //byte[] data return So we used bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(u.getImg(),0, u.getImg().length);
        holder.img.setImageBitmap(bitmap);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phnum = "tel:" + u.getPhone();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phnum));
                if(ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(context, "Please Grant Permission", Toast.LENGTH_LONG).show();
                    requestionPermission();
                }
                else {
                    context.startActivity(intent);
                }
            }
        });
    }
    private void requestionPermission(){
        ActivityCompat.requestPermissions((Activity)context, new String[]{Manifest.permission.CALL_PHONE},1);
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tid, tname, tphone,tmail;
        private ImageView img,call;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tid=itemView.findViewById(R.id.t1);
            tname = itemView.findViewById(R.id.t2);
            tphone = itemView.findViewById(R.id.txt_phone);
            tmail = itemView.findViewById(R.id.txt_email);
            img = itemView.findViewById(R.id.ima);
            call =itemView.findViewById(R.id.img_call);
        }
    }
}
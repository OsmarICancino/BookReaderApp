package com.dalvik.bookreaderapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dalvik.bookreaderapp.R;
import com.dalvik.bookreaderapp.model.Book;
import com.dalvik.bookreaderapp.utils.PermissionUtils;

import java.util.ArrayList;

/**
 * Created by alckon on 22/04/16.
 * Copyright Todos los Derechos Reservados | Dalvik 2016
 * Desarrollador: Osmar I. Cancino <o.cancinodiaz@gmail.com>
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private Activity context;
    private ArrayList<Book> items;
    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1;

    PermissionUtils permissionUtils;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        private TextView txtCategory;
        private TextView txtName;
        private TextView txtDescription;

        public MyViewHolder(View v) {
            super(v);
            txtCategory = (TextView) v.findViewById(R.id.txtCategiry);
            txtName = (TextView) v.findViewById(R.id.txtName);
            txtDescription = (TextView) v.findViewById(R.id.txtDescription);
        }
    }

    public BookAdapter(Activity context, ArrayList<Book> items) {
        this.items = items; //-> Recibe la variable en el constructor
        this.context = context;
        permissionUtils = new PermissionUtils();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.book_row, viewGroup, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int i) {

        viewHolder.txtCategory.setText(items.get(i).categoria);
        viewHolder.txtName.setText(items.get(i).nombre.toUpperCase());
        viewHolder.txtDescription.setText(items.get(i).descripcion);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (permissionUtils.checkPermission(context, STORAGE_PERMISSION_REQUEST_CODE, view)) {
                    try {
                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.2.2/Biblioteca/archivos/" + items.get(i).nombre_archivo)));
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            }
        });

    }


}

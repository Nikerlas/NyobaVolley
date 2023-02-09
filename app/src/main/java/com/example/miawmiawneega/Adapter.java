package com.example.miawmiawneega;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Base64;
import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends BaseAdapter{

    Activity activity;
    List<Data> items;
    private LayoutInflater inflater;
    private Bitmap[] bitmaps;

    public Adapter(Activity activity, List<Data> items) {
        this.activity  =activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) convertView = inflater.inflate(R.layout.list, null);

        ImageView pic = (ImageView) convertView.findViewById(R.id.pic);
        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.alamat);
        TextView tgl_lahir = (TextView) convertView.findViewById(R.id.tgl_lahir);

        Data data = items.get(position);

        pic.setImageBitmap(Bitmap.createScaledBitmap(bitmaps[position], 10,5,false));
        id.setText(data.getId());
        nama.setText(data.getNama());
        alamat.setText(data.getAlamat());
        tgl_lahir.setText(data.getTgl_lahir());

        return convertView;

    }
}

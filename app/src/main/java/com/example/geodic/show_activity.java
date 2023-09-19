package com.example.geodic;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bumptech.glide.Glide;
import com.example.geodic.COUNTRIES.Countries_Table;
import com.example.geodic.COUNTRIES.Country;
import com.example.geodic.NATION.NATION;
import com.example.geodic.NATION.Nation_Table;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class show_activity extends AppCompatActivity {
    public int Current_theme;
    private ImageView imageView;
    private StorageReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        imageView=findViewById(R.id.internetView);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        FloatingActionButton a = findViewById(R.id.floatingActionButton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(show_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent extras = getIntent();
        String  OBJ_Name= "default";
        String OBJ_DATA = "default";
        String  OBJ_SEAR= "default";

        if (extras != null) {
            OBJ_Name = extras.getStringExtra("name");
            OBJ_DATA= extras.getStringExtra("result");
             OBJ_SEAR= extras.getStringExtra("search")+".png";
        }
       TextView objd=findViewById(R.id.objectData);
        TextView objn=findViewById(R.id.objectName);
   if (OBJ_DATA!=null && OBJ_Name!=null) {
    objd.clearComposingText();
    objn.setText(OBJ_Name);
    objd.setText(OBJ_DATA);
    new GetImageTask(imageView).execute(OBJ_SEAR);
        }
    }
    public class GetImageTask extends AsyncTask<String, Void,Void> {
        protected ProgressDialog dialog;
        ImageView im;

        public GetImageTask(ImageView viewById) {
            this.im=viewById;
        }


        @Override
        protected Void doInBackground(String... strings) {
            FirebaseStorage storage=FirebaseStorage.getInstance();
            StorageReference imgref=storage.getReference()
                    .child("Countries").child(strings[0]);
            imgref.getBytes(1024*1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    imageView.setImageBitmap(bitmap);
                    dialog.dismiss();
                }
            });
            dialog.dismiss();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(
                    show_activity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            String DeviceLang = Resources.getSystem().getConfiguration().locale.getLanguage();
            String image_name=null;
            if (DeviceLang.equalsIgnoreCase("en")) {
            image_name="Obtaining an image...";
            }
            else image_name="Получение изображения...";
            dialog.setMessage(image_name);
            dialog.setCancelable(false);
            dialog.show();
        }



    }
}

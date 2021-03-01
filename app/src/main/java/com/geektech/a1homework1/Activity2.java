package com.geektech.a1homework1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity2 extends AppCompatActivity {
    private ImageView imageView2;
    private ImageView imageView1;
    private EditText editText;
    private static final int GALLERY_REQUEST_CODE = 123;
    private static String  uriImage;
    protected static final String EXTRA_EDIT_KEY = "editText key";
    protected static final String EXTRA_IMAGE_KEY = "image key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

       }

    public void openGallery(View view){
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);


        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent , GALLERY_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            uriImage = String.valueOf(data.getData());
        }
    }

    public void returnData(View view) {

        editText = findViewById(R.id.editText);
        String str = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_EDIT_KEY,str);
        intent.putExtra(EXTRA_IMAGE_KEY,uriImage);

        setResult(RESULT_OK,intent);
        finish();
    }
}
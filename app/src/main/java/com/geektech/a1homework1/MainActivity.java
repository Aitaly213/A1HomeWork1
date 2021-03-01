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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView12;
    ImageView imageView12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView12 = findViewById(R.id.myTextView);
        imageView12 = findViewById(R.id.imageView1);
    }

    public void openActivity(View view){
        Intent intent = new Intent(MainActivity.this,Activity2.class);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String stringImage = data.getStringExtra(Activity2.EXTRA_IMAGE_KEY);
        String stringEditText = data.getStringExtra(Activity2.EXTRA_EDIT_KEY);
        textView12.setText(stringEditText);

        imageView12.setImageURI(Uri.parse(stringImage));
    }

    public void openGMail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        String[] strTo = { "aitalyasanbaev@gmail.com" };
        intent.putExtra(Intent.EXTRA_EMAIL, strTo);
        intent.putExtra(Intent.EXTRA_TEXT, String.valueOf(textView12.getText()));
        intent.setType("message/rfc822");
        intent.setPackage("com.google.android.gm");
        startActivity(intent);
    }
}
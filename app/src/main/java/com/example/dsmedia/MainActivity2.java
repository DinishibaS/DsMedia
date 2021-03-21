package com.example.dsmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         Button button = findViewById(R.id.button);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 switch (v.getId()) {

                     case R.id.button:
                         signOut(button);
                         break;

                 }
             }
         });

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView1);
        mAuth = FirebaseAuth.getInstance();


        FirebaseUser user = mAuth.getCurrentUser();
        if (user!=null){



            textView.setText(user.getEmail());
            textView1.setText(user.getDisplayName());
            Uri personPhoto = user.getPhotoUrl();
            Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
        }
    }
    public void signOut(View view){
        mAuth.signOut();
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }

}

package com.example.fitness247.Activity;

import static android.app.PendingIntent.getActivity;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.fitness247.Domain.Ex_Lst_Domain;
import com.example.fitness247.Domain.ExerciseDomain;
import com.example.fitness247.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class UserProfile extends AppCompatActivity {
    private ImageView avata;
    private TextView full_name,bim,height, weight;
    private Button btn_update;
    LinearLayout home_button, supports_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        initUI();
        showInfor();
        initListener();
    }
    private void initUI()
    {
        home_button = findViewById(R.id.home_button);
        home_button.setOnClickListener(mListener);
        supports_button = findViewById(R.id.support_button);
        supports_button.setOnClickListener(mListener);

        avata = findViewById(R.id.img_user);
        full_name = findViewById(R.id.ed_full_name);
        bim = findViewById(R.id.tv_bmi);
        height = findViewById(R.id.ed_height);
        weight = findViewById(R.id.ed_weight);
        btn_update = findViewById(R.id.btn_update);
    }
    View.OnClickListener mListener = new View.OnClickListener(){
        @Override
        public void onClick(View view)
        {
            int id = view.getId();
            switch(id)
            {
                case R.id.home_button:
                    Intent intent = new Intent(UserProfile.this,MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.support_button:
                    intent = new Intent(UserProfile.this,Supports_Activity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }

    };

    private void showInfor(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String Path = user.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Path);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User value = dataSnapshot.getValue(User.class);
                String name =value.getFullName();
                Double hei = ((Double) value.getHeight());
                Double wei =((Double) value.getWeight());
                Double set_bmi = 0.0;
                set_bmi = (double) Math.ceil((wei / (hei * hei/10000)  * 10) / 10);;
                String bmi_up = String.valueOf(set_bmi);

                full_name.setText(name);
                bim.setText(bmi_up);
                height.setText(String.valueOf(hei));
                weight.setText(String.valueOf(wei));

            }
            @Override
            public void onCancelled(DatabaseError error) {
                String name_ud = full_name.getText().toString().trim();
                String h = height.getText().toString().trim();
                String w =weight.getText().toString().trim();
            }
        });

        //Uri img = user.getPhotoUrl();
        //Glide.with(this).load(img).error(R.drawable.profile).into(avata);
    }

    private void initListener(){
//        avata.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                onClickRequestPermission();
//            }
//        });

        btn_update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                onClickProfile();
            }
        });
    }

    private void onClickProfile()
    {
        String name_ud = full_name.getText().toString().trim();
        String h = height.getText().toString().trim();
        String w =weight.getText().toString().trim();
        Double hei_ud = Double.parseDouble(h) ;
        Double wei_ud = Double.parseDouble(w);
        Double bmi_up = (double) Math.ceil((wei_ud / (hei_ud * hei_ud/10000)  * 10) / 10);

        bim.setText(String.valueOf(bmi_up));
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String Path = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(Path);

        User myPr = new User(name_ud,hei_ud,wei_ud);
        myRef.setValue(myPr, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(UserProfile.this,"succer!!",Toast.LENGTH_LONG).show();

            }
        });

    }

//    private void onClickRequestPermission()
//    {
//        MainActivity mainActivity;
//        mainActivity = ( MainActivity) UserProfile.this;
//        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
//        {
//            openGallery();
//            return;
//        }
//
//        if(this.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
//        {
//            openGallery();
//        }
//        else
//        {
//            String []permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
//            this.requestPermissions(permission,MY_REQUEST_CODE);
//        }
//    }

}


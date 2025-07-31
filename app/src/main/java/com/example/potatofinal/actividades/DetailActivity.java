package com.example.potatofinal.actividades;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.potatofinal.R;
import com.example.potatofinal.databinding.ActivityDetailBinding;
import com.example.potatofinal.dominios.Item;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private Item object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();

        }

    private void setVariable() {
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.backBtn.setOnClickListener(v -> finish());
        binding.bedTxt.setText(""+object.getBed());
        binding.durationTxt.setText(object.getDuration());
        binding.distanceTxt.setText(object.getDistance());
        binding.descriptionTxt.setText(object.getDescription());
        binding.addressTxt.setText(object.getAddress());
        binding.ratingBar2.setRating((float)object.getScore());
        binding.ratingTxt.setText(object.getScore()+"Reseñas");

        Glide.with(DetailActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getIntentExtra() {
        object=(Item) getIntent().getSerializableExtra("object");

    });
    }
}
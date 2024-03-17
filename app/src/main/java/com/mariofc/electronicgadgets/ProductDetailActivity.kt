package com.mariofc.electronicgadgets

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mariofc.electronicgadgets.R
import com.mariofc.electronicgadgets.databinding.ActivityProductDetailBinding
import com.mariofc.electronicgadgets.model.Product

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var layout: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        layout = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(layout.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initialize()
    }

    @SuppressLint("SetTextI18n")
    private fun initialize(){
        val product = intent.getSerializableExtra("product") as Product
        val imageId = intent.getIntExtra("image", -1);

        layout.productImage.setImageResource(imageId)
        layout.productNameTextview.text = product.productName
        layout.descriptionTextview.text = product.productDescription
        layout.priceTextview.text = "$ " + product.cost.toString()

        layout.homeBtn.setOnClickListener(this::onHomeBtnClick)
    }

    private fun onHomeBtnClick(view:View){
        finish()
    }
}
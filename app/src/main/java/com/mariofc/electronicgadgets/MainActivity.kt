package com.mariofc.electronicgadgets

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mariofc.electronicgadgets.adapter.ProductsRecyclerViewAdapter
import com.mariofc.electronicgadgets.databinding.ActivityMainBinding
import com.mariofc.electronicgadgets.model.Product
import com.mariofc.electronicgadgets.viewholder.ProductViewHolder

class MainActivity : AppCompatActivity() {
    private lateinit var layout: ActivityMainBinding
    private lateinit var products: List<Product>
    private lateinit var productImages: List<Int>
    private lateinit var brandLogos: List<Int>
    private lateinit var cart: HashMap<Int, Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initialize()
    }

    private fun initialize() {
        products = listOf(
            Product("iPad", "iPad Pro 11-inch", 400.0),
            Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00),
            Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00),
            Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00),
            Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00)
        )

        productImages = listOf(
            R.drawable.ipad,
            R.drawable.mac,
            R.drawable.dell_laptop,
            R.drawable.keyboard,
            R.drawable.mac_2
        )

        brandLogos = listOf(
            R.drawable.apple_logo,
            R.drawable.apple_logo,
            R.drawable.dell_logo,
            R.drawable.logitech_logo,
            R.drawable.apple_logo
        )

        cart = HashMap()

        val adapter = ProductsRecyclerViewAdapter(products, productImages, brandLogos, cart)
        layout.recyclerView.layoutManager = LinearLayoutManager(this)
        layout.recyclerView.adapter = adapter

        layout.viewCartBtn.setOnClickListener(this::onViewCartBtnClick)

    }

    private fun onViewCartBtnClick(view: View) {
        if (cart.size == 0) {
            Toast.makeText(this, "You have no items in your cart.", Toast.LENGTH_SHORT).show()
        } else {
            var cartItems = "";
            cart.keys.forEach { k -> run{
                if(cartItems.isNotEmpty()) cartItems+=", "
                cartItems += " ${products[k].productName}: ${cart[k]}"
            } }

            Toast.makeText(this, cartItems, Toast.LENGTH_SHORT).show()
        }
    }
}
package com.mariofc.electronicgadgets.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mariofc.electronicgadgets.ProductDetailActivity
import com.mariofc.electronicgadgets.R
import com.mariofc.electronicgadgets.model.Product
import com.mariofc.electronicgadgets.viewholder.ProductViewHolder

class ProductsRecyclerViewAdapter(
    private var products: List<Product>,
    private var images: List<Int>,
    private var logos: List<Int>,
    private var cart:HashMap<Int, Int>
) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.productImageView.setImageResource(images[position])
        holder.brandLogoImageView.setImageResource(logos[position])
        holder.productNameTextView.text = products[position].productName
        holder.priceTextView.text = "\$ ${products[position].cost}"
        holder.descriptionTextView.text = products[position].productDescription

        holder.addBtn.setOnClickListener{
            run{
                cart[position] = (cart[position] ?: 0) + 1
                Toast.makeText(holder.itemView.context, "Item added to cart!", Toast.LENGTH_SHORT).show()
            }}

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ProductDetailActivity::class.java)
            intent.putExtra("product", products[position])
            intent.putExtra("image", images[position])

            holder.itemView.context.startActivity(intent)
        }
    }

}
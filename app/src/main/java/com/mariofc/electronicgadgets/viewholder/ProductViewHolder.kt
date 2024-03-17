package com.mariofc.electronicgadgets.viewholder

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mariofc.electronicgadgets.R

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var productImageView:ImageView
    var brandLogoImageView:ImageView
    var productNameTextView:TextView
    var addBtn:Button
    var priceTextView:TextView
    var descriptionTextView:TextView

    init {
        productImageView = itemView.findViewById(R.id.product_image)
        brandLogoImageView = itemView.findViewById(R.id.brand_logo)
        productNameTextView = itemView.findViewById(R.id.product_name_textview)
        addBtn = itemView.findViewById(R.id.add_btn)
        priceTextView = itemView.findViewById(R.id.price_textview)
        descriptionTextView = itemView.findViewById(R.id.description_textview)
    }
}
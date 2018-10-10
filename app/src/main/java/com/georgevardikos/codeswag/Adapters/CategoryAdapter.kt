package com.georgevardikos.codeswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.georgevardikos.codeswag.Model.Category
import com.georgevardikos.codeswag.R

/**
 * Created by gvardikos on 09/10/2018.
 */
class CategoryAdapter(context: Context, categories: List<Category>): BaseAdapter() {

    val mCategories = categories
    val mContext = context


    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val categoryView: View
        categoryView = LayoutInflater.from(mContext).inflate(R.layout.category_list_item, null)
        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName: TextView = categoryView.findViewById(R.id.categoryName)

        val resourceId = mContext.resources.getIdentifier(mCategories[position].image, "drawable",mContext.packageName)
        categoryImage.setImageResource(resourceId)
        categoryName.text = mCategories[position].title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return mCategories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return mCategories.size
    }
}
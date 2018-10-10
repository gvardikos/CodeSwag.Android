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
class CategoryAdapter(val mContext: Context, val mCategories: List<Category>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val categoryView: View
        val holder: ViewHolder

        //the first time that cells are presented
        if (convertView == null) {
            categoryView = LayoutInflater.from(mContext).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            //by giving the reference to the ViewHolder we recycle the views instead of recreating them all the time.
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val resourceId = mContext.resources.getIdentifier(mCategories[position].image, "drawable",mContext.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = mCategories[position].title

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

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}
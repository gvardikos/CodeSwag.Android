package com.georgevardikos.codeswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import com.georgevardikos.codeswag.Adapters.CategoryAdapter
import com.georgevardikos.codeswag.Adapters.CategoryRecycleAdapter
import com.georgevardikos.codeswag.Model.Category
import com.georgevardikos.codeswag.R
import com.georgevardikos.codeswag.Services.DataService
import com.georgevardikos.codeswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->

            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)

        }

        main_categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        main_categoryListView.layoutManager = layoutManager
        main_categoryListView.setHasFixedSize(true)


    }
}

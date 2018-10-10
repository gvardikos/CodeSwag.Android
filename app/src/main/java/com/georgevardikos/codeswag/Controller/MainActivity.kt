package com.georgevardikos.codeswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.georgevardikos.codeswag.Adapters.CategoryAdapter
import com.georgevardikos.codeswag.Model.Category
import com.georgevardikos.codeswag.R
import com.georgevardikos.codeswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        main_categoryListView.adapter = adapter
    }
}

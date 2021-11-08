package com.bookwishlist

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bookwishlist.repo.InMemoryRepository
import com.bookwishlist.viewmodel.BookItemRecyclerViewAdapter
import com.bookwishlist.viewmodel.BookViewHolder
import com.bookwishlist.viewmodel.BookViewModel
import com.bookwishlist.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var repo: InMemoryRepository = InMemoryRepository()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myLayoutManager = LinearLayoutManager(this)
        var viewAdapter = BookItemRecyclerViewAdapter()
        viewAdapter.setBooksList(repo.getAllBooks())


        recycle_list.apply {
            setHasFixedSize(true)
            layoutManager = myLayoutManager  //bug stupid de 2 ore :)
            adapter = viewAdapter
        }

        val viewModel = ViewModelProvider(this, ViewModelFactory(InMemoryRepository()))
            .get(BookViewModel::class.java)

        viewModel.movieList.observe(this, Observer {
            viewAdapter.setBooksList(it)
        })

        viewModel.getAllBooks()

//        add_button.setOnClickListener{
//            val intent = Intent(this.applicationContext,AddActivity::class.java)
//            val addActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
//                viewAdapter.notifyDataSetChanged()
//            }
//            addActivityLauncher.launch(intent)
//        }
    }



}
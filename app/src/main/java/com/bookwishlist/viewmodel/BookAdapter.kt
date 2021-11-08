package com.bookwishlist.viewmodel


import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bookwishlist.R
import com.bookwishlist.domain.Book
import kotlinx.android.synthetic.main.book_item_list.view.*

class BookItemRecyclerViewAdapter: RecyclerView.Adapter<BookViewHolder>() {

    var books = mutableListOf<Book>()

    @SuppressLint("NotifyDataSetChanghed")
    fun setBooksList(books: List<Book>){
        this.books = books.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder{
       // this.context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item_list, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val item = books[position]
        holder.nameView.text = item.name
        holder.authorView.text = item.author
        holder.deleteButton.setOnClickListener{
            //TODO
            //instantiate a dialog before deleting the item
            //????  Ask how to do it

//            AlertDialog.Builder(context)
//                .setMessage(R.string.delete_agreement)
//                .setPositiveButton(R.string.yes,DialogInterface.OnClickListener{
//                        dialog , position ->
//                            books.remove(item)
//                            setBooksList(books)
//                           // books.removeAt(position)
//                            //dialog.dismiss()
//
//                }).setNegativeButton(R.string.no ,null)
//                .show()
            books.remove(item)
            setBooksList(books)
        }
    }

    override fun getItemCount() = books.size

}

class BookViewHolder(view: View): RecyclerView.ViewHolder(view)  {
    var nameView: TextView = view.name
    var authorView: TextView = view.author
    var deleteButton: ImageButton = view.delete_button
}
package com.bookwishlist.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.bookwishlist.R
import java.lang.IllegalStateException

class DeleteBookDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.delete_agreement)
                .setPositiveButton(R.string.yes,DialogInterface.OnClickListener{
                    dialog ,id ->
                    //TODO
                    //???????? how to write the item deletion here
                }).setNegativeButton(R.string.no ,DialogInterface.OnClickListener{
                        dialog, _ -> dialog.dismiss()
                })
            builder.create()
        } ?: throw IllegalStateException("Activity can't be null!")
    }

}
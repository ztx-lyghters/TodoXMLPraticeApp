package ztx.lyghters.todoxmlpraticeapp.ui.dialogs

import android.content.Context
import androidx.appcompat.app.AlertDialog
import ztx.lyghters.todoxmlpraticeapp.domain.models.Todo

fun showDeleteTodoDialog(
    context: Context,
    todo: Todo,
    callback: () -> Unit,
): AlertDialog {
    return AlertDialog.Builder(context)
    .setTitle("Delete element?")
    .setMessage("Are you sure you want to delete ${todo.title}?")
    .setNegativeButton("Cancel", null)
    .setPositiveButton("Delete") { dialog, _ ->
        callback()
        dialog.dismiss()
    }.show()
}
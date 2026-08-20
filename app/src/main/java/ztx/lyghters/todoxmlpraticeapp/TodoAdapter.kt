package ztx.lyghters.todoxmlpraticeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ztx.lyghters.todoxmlpraticeapp.databinding.ItemTodoBinding

class TodoAdapter(
    var todos: List<Todo>,
    val onItemLongClick: (position: Int) -> Unit,
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)

        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TodoViewHolder,
        position: Int,
    ) {
        holder.binding.apply {
            todos[position].apply {
                tvTodoTitle.text = title
                cbTodoDone.isChecked = isChecked
                layoutTodoItem.setOnLongClickListener {
                    androidx.appcompat.app.AlertDialog.Builder(root.context)
                        .setTitle("Delete element?")
                        .setMessage("Are you sure you want to delete ${tvTodoTitle.text.toString()}?")
                        .setPositiveButton("Delete") { dialog, _ ->
                            onItemLongClick(position)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, todos.size)
                            dialog.dismiss()
                        }
                        .setNegativeButton("Cancel", null)
                        .show()
                    true
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class TodoViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root)
}
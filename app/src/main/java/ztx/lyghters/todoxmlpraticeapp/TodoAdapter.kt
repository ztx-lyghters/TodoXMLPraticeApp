package ztx.lyghters.todoxmlpraticeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ztx.lyghters.todoxmlpraticeapp.databinding.ItemTodoBinding

class TodoAdapter(
    var todos: List<Todo>,
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private var _binding: ItemTodoBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ItemTodoBinding must not be null")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TodoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _binding = ItemTodoBinding.inflate(layoutInflater, parent, false)

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
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class TodoViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root)
}
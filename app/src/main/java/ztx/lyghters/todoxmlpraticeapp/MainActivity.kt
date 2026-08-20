package ztx.lyghters.todoxmlpraticeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ztx.lyghters.todoxmlpraticeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ActivityMainBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val todoList = mutableListOf(
            Todo("Do some thing", false),
            Todo("Do some other thing", false),
            Todo("Don't do what's already done", true),
        )

        val adapter = TodoAdapter(todoList)

        with(binding) {
            rvTodoList.adapter = adapter
            rvTodoList.layoutManager = LinearLayoutManager(this@MainActivity)

            btnTodoNewAdd.setOnClickListener {
                if (etTodoNewText.text.isNotEmpty()) {
                    todoList.add(
                        Todo(
                            etTodoNewText.text.toString(),
                            false,
                        )
                    )
                    adapter.notifyItemInserted(todoList.size - 1)
                }
            }
        }
    }
}
package dev.abdujabbor.roomdatabasesimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.abdujabbor.roomdatabasesimple.adapters.RvAdapter
import dev.abdujabbor.roomdatabasesimple.databinding.ActivityMainBinding
import dev.abdujabbor.roomdatabasesimple.db.AppDataBase
import dev.abdujabbor.roomdatabasesimple.models.Manager

class MainActivity : AppCompatActivity() {
    lateinit var appDataBase: AppDataBase
    private lateinit var adapter: RvAdapter
    private lateinit var list: ArrayList<Manager>
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDataBase = AppDataBase.getInstance(this)
        adapter = RvAdapter(appDataBase.myDao().getAllManager() as ArrayList<Manager>)
        binding.recycelrview.adapter = adapter


        binding.btnSave.setOnClickListener {
            var name = binding.edtName.text.toString()
            var number = binding.edtNumber.text.toString()

            val manager = Manager(name,number)

            appDataBase.myDao().addManager(manager)
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            adapter.notifyItemInserted(appDataBase.myDao().getAllManager().size -1)

        }

        setContentView(binding.root)
    }
}
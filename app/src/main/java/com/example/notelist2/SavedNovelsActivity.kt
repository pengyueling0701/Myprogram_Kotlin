package com.example.notelist2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notelist2.databinding.ActivitySavedNovelsBinding
import java.io.File
import java.io.FileInputStream

class SavedNovelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedNovelsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedNovelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadSavedNovel()
    }

    private fun loadSavedNovel() {
        val file = File(filesDir, "novel.txt")

        if (file.exists()) {
            try {
                val inputStream = FileInputStream(file)
                val content = inputStream.bufferedReader().use { it.readText() }
                binding.tvSavedNovel.text = content
                inputStream.close()
            } catch (e: Exception) {
                Toast.makeText(this, "Error loading novel: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        } else {
            binding.tvSavedNovel.text = "No novel saved yet."
        }
    }
}

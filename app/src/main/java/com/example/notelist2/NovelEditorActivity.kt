package com.example.notelist2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notelist2.databinding.ActivityNovelEditorBinding
import java.io.File
import java.io.FileOutputStream

class NovelEditorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNovelEditorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovelEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveNovel.setOnClickListener {
            val novelText = binding.etNovelContent.text.toString()
            if (novelText.isNotEmpty()) {
                saveNovel(novelText)
            } else {
                Toast.makeText(this, "Please write something before saving.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveNovel(novelText: String) {
        val file = File(filesDir, "novel.txt")

        try {
            val outputStream = FileOutputStream(file)
            outputStream.write(novelText.toByteArray())
            outputStream.close()

            Toast.makeText(this, "Novel saved successfully!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error saving novel: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

package com.example.notelist2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.notelist2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigate to the NovelEditorFragment to start writing a new novel
        binding.btnWriteNovel.setOnClickListener {
            val intent = Intent(this, NovelEditorActivity::class.java)
            startActivity(intent)
        }

        // Navigate to the SavedNovelsFragment to view saved novels
        binding.btnViewSavedNovels.setOnClickListener {
            val intent = Intent(this, SavedNovelsActivity::class.java)
            startActivity(intent)
        }
    }
}

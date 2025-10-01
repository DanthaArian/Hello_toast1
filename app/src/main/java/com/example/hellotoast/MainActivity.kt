package com.example.hellotoast

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Deklarasi Global
    private var mCount: Int = 0
    private lateinit var mShowCount: TextView // Gunakan lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi View
        mShowCount = findViewById<TextView>(R.id.show_count) // Inisialisasi mShowCount
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)

        // Perbaikan: Hapus kurung tutup ekstra
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)


        buttonCountUp.setOnClickListener(View.OnClickListener {
            mCount++ // Perbaikan: Hapus titik koma
            Log.d("mCount", mCount.toString()) // Perbaikan: Gunakan mCount.toString()
            mShowCount.text = mCount.toString() // mShowCount dijamin ada karena lateinit
        })


        buttonToast.setOnClickListener(View.OnClickListener {
            // Perbaikan: mShowCount dijamin ada, hapus '?'
            val tulisan: String = mShowCount.text.toString()
            val toast: Toast = Toast.makeText(this, "Angka yang dimunculkan "+tulisan, Toast.LENGTH_LONG)
            toast.show()
        })


        buttonSwitchPage.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        })
    }
}
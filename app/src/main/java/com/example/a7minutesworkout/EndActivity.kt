package com.example.a7minutesworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import com.example.a7minutesworkout.databinding.ActivityEndBinding
import com.example.a7minutesworkout.databinding.ActivityMainBinding
import java.util.*

class EndActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var binding: ActivityEndBinding? = null
    private var tts: TextToSpeech? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarEndActivity)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarEndActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        tts = TextToSpeech(this, this)
        speakOut(binding?.tvCongrats?.text.toString())

        binding?.btnFinish?.setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The language speciafied is not supported!")
            }
        } else {
            Log.e("TTS", "Initialization failed!")

        }
    }

    private fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
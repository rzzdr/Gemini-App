package com.rudrpsingh.gemini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rudrpsingh.gemini.chat.Main
import com.rudrpsingh.gemini.ui.theme.GeminiTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GeminiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        color = Color(0xFF131314)
                    ){
                        Main(Modifier
                            .fillMaxSize()
                            )
                    }
                }
            }
        }
    }
}

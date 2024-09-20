package com.ssafy.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ssafy.ar.ARSceneComposable
import com.ssafy.ar.ARViewModel
import com.ssafy.demo.ui.theme.MoyaTheme

class MainActivity : ComponentActivity() {

    private val viewModel: ARViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MoyaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ARSceneComposable(
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}
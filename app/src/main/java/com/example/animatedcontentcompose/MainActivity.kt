package com.example.animatedcontentcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animatedcontentcompose.ui.theme.AnimatedContentComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var count by remember {
                mutableIntStateOf(0)
            }
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {
                AnimatedContent(targetState = count, label = "animated", transitionSpec = {
                    slideInVertically(
                        initialOffsetY = {-it},
                        animationSpec = tween(500)
                    ) togetherWith slideOutVertically (
                        targetOffsetY = {it},
                        animationSpec = tween(500)
                    )
                }) {
                    targetCount -> Text(text = targetCount.toString(),
                        fontFamily = FontFamily.Serif,
                        fontSize = 200.sp)
                }
                Button(onClick = { count++}, colors = ButtonDefaults.buttonColors(containerColor = Color.Black) ) {
                    Text(text = "Add Number", fontSize = 22.sp,)

                }
            }

        }
    }
}


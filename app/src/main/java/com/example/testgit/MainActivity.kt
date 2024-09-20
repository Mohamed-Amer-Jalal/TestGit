package com.example.testgit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.testgit.ui.theme.TestGitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            println("Hello Git & Android")
            TestGitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DraggableDragon(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                    Text(text = "Git & Android")
                    Text(text = "Git")
                    Text(text = "Hello Git Fully")
                    Text(text = "Hello Android")
                }
                Text(text = "final Git")
                Text(text = "final Android & GitHub")
            }
        }
    }
}

@Composable
fun DraggableDragon(
    modifier: Modifier = Modifier
) {
    // نبدأ إحداثيات التنين من الموقع (0, 0)
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }

    // صندوق (Box) يمثل التنين
    Box(
        modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    // تحديث إحداثيات التنين بناءً على السحب
                    offset += dragAmount
                    change.consume() // نستهلك حدث السحب
                }
            }
    ) {
        Box(
            modifier
                .offset { IntOffset(offset.x.toInt(), offset.y.toInt()) }
                .size(100.dp)
                .background(Color.Green, shape = CircleShape) // هذا يمثل شكل التنين
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DraggableDragon()
}
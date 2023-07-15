package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(message = "Happy Birthday Sam!", from = "From Gilgamesh")
                }
            }
        }
    }
}

// Composable functions are foundations of a UI
/*  Describes some part of UI, doesn't return anything, transforms input to display elements, and might emit
    several UI elements.
* */
@Composable // annotation - tells compiler/coder what it is
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) { // convention for Composable take modifier parameter
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}
// Summary: GreetingText = function which calls  Text() composable function to display text in UI

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingText(message = "Happy Birthday Sam!", from = "From Gilgamesh")
    }
}

/* Scalable pixels (SP) - measure of font size based on user settings
Density-independent pixels (DP) - same size as SP; used for layout
*
UI Hierarchy - parents and children components / containers; Column, Row, Box

Trailing lambda syntax - when the last parameter of a function is a function
Basically you will have the composable function and use {} brackets and directly type the
child composable functions inside, (instead of having the original with () parentheses and having a
parameter = {composable1() composable2()}

Remember to put the modifier on the @Composable annotation

Convention to increment padding by increments of 4.dp

Convention to pass modifier attributes along with modifier from parent composable
* */
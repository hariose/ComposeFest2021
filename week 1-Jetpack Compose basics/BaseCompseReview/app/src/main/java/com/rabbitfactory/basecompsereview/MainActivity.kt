package com.rabbitfactory.basecompsereview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rabbitfactory.basecompsereview.ui.theme.BaseCompseReviewTheme

class MainActivity : ComponentActivity() {

    var StringArray = arrayListOf<String>("One", "Two", "Three")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseCompseReviewTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String) {

    val context = LocalContext.current

    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = {
                    expanded = !expanded

                    if(expanded){
                        Toast.makeText(
                            context,
                            extraPadding.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            extraPadding.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
private fun ToastMassage(Text: String) {

    val context = LocalContext.current

    Toast.makeText(
        context,
        Text,
        Toast.LENGTH_SHORT
    ).show()

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaseCompseReviewTheme {
        MyApp()
    }
}

@Composable
fun OnboardingScreen() {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hello, World!",
                Modifier
                    .padding(16.dp) // Outer padding; outside background
                    .background(color = Color.Green) // Solid element background color
                    .padding(32.dp) // Inner padding; inside background, around text
            )

            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = { shouldShowOnboarding = false }
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BaseCompseReviewTheme {
        OnboardingScreen()
    }
}
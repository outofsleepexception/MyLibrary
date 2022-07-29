package com.example.clientapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.arber.mylibrary.SdkFlowContract
import com.arber.mylibrary.SdkLauncher
import com.arber.mylibrary.SdkResult
import com.example.clientapp.ui.theme.ClientAppTheme

class MainActivity : ComponentActivity() {

    val resultLauncher = registerForActivityResult(SdkFlowContract()) { sdkResult ->
        when (sdkResult) {
            is SdkResult.Success -> {
                showToast(sdkResult.successMessage)
            }
            is SdkResult.Error -> {
                showToast("An error happened")
            }
            is SdkResult.Cancel -> {
                showToast("Canceled")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClientAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val context = LocalContext.current
                    Column(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Greeting("Android")
                        Question()
                        ElevatedButton(
                            onClick = {
                                SdkLauncher.launchFlow(resultLauncher = resultLauncher)
                            }
                        ) {
                            Text(text = "Click here")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Question() {
    Text(
        text = "Do you want to initialize myLibrary SDK?",
        modifier = Modifier.padding(
            top = Dp(48f),
            bottom = Dp(16f),
        ),
    )
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ClientAppTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//            val context = LocalContext.current
//            Column(
//                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Greeting("Android")
//                Question()
//                ElevatedButton(
//                    onClick = {
//                        SdkLauncher.launchFlow(resultLauncher = resultLauncher)
//                    }
//                ) {
//                    Text(text = "Click here")
//                }
//            }
//        }
//    }
//}
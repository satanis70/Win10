package com.example.win10

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import coil.compose.rememberAsyncImagePainter
import com.example.win10.ui.theme.Win10Theme
import com.onesignal.OneSignal

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            val context = LocalContext.current
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.teal_200)),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.soccer),
                        contentDescription = ""
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(top = 14.dp)
                ) {
                    Text(
                        modifier = Modifier,
                        text = "TIPS BET APP",
                        fontSize = 32.sp,
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(context, TipsActivity::class.java)
                            startActivity(intent)
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(32.dp)
                    ) {
                        Text(text = "How to Bet on Sports for Beginners", fontSize = 18.sp)
                    }
                    Button(
                        onClick = {
                            val intent = Intent(context, AppsActivity::class.java)
                            startActivity(intent)
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(32.dp)
                    ) {
                        Text(text = "Us Sports betting apps - legal and licensed", fontSize = 18.sp)
                    }
                    Button(
                        onClick = {
                            val intent = Intent(context, MultibetActivity::class.java)
                            startActivity(intent)
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(32.dp)
                    ) {
                        Text(text = "Simple Ways To Improve Your Multi Betting", fontSize = 18.sp)
                    }
                }
            }

        }
    }
}
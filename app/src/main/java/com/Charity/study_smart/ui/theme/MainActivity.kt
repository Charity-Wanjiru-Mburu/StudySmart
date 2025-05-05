package com.Charity.study_smart.ui.theme

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.Charity.study_smart.ui.theme.presentation.session.StudySessionTimerService
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Study_SmartTheme {
//                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
//
//                }
//            }
//        }
//    }
//}
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var isBound by mutableStateOf(false)
    private lateinit var timerService: StudySessionTimerService
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            val binder = service as StudySessionTimerService.StudySessionTimerBinder
            timerService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, StudySessionTimerService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            if (isBound) {
                StudySmartTheme {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        dependenciesContainerBuilder = {
                            dependency(SessionScreenRouteDestination) { timerService }
                        }
                    )
                }
            }
        }
        requestPermission()
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        isBound = false
    }
}
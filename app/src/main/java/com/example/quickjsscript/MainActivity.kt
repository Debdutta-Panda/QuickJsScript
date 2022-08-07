package com.example.quickjsscript

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickjsscript.ui.theme.QuickJsScriptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: MainViewModel = viewModel()
            QuickJsScriptTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(0.5f)
                        ){
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ){
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Text("JavaScript")
                                    IconButton(onClick = {
                                        vm.onScriptClear()
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Clear"
                                        )
                                    }
                                }
                                TextField(
                                    value = vm.scriptText.value,
                                    onValueChange = {
                                        vm.scriptText.value = it
                                    },
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    placeholder = {
                                        Text("Script")
                                    }
                                )
                            }
                        }
                        Divider()
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                        ){
                            Column {
                                OutlinedTextField(
                                    value = vm.inputText.value,
                                    onValueChange = {
                                        vm.inputText.value = it
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    placeholder = {
                                        Text("Input")
                                    }
                                )
                                Button(
                                    onClick = {
                                        vm.onRun()
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {
                                    Text("Run")
                                }
                                Text(
                                    "Result: "+vm.outputText.value,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 16.dp)
                                        .verticalScroll(rememberScrollState())
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
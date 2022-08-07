package com.example.quickjsscript

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.quickjs.QuickJS


class MainViewModel: ViewModel() {
    val scriptText = mutableStateOf("")
    val inputText = mutableStateOf("")
    val outputText = mutableStateOf("")

    var quickJS = QuickJS.createRuntime()
    var context = quickJS.createContext()
    fun onRun() {
        try {
            val output = context.executeStringScript("var input = '${inputText.value}';\n"+scriptText.value, "file.js")
            outputText.value = output
        } catch (e: Exception) {
            outputText.value = e.message?:""
        }
    }

    fun onScriptClear() {
        scriptText.value = ""
    }
}
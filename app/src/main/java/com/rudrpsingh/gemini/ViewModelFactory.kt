package com.rudrpsingh.gemini

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.BlockThreshold
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.generationConfig
import com.rudrpsingh.gemini.chat.ChatViewModel

val GenerativeViewModelFactory = object : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        viewModelClass: Class<T>,
        extras: CreationExtras
    ): T {
        val config = generationConfig {
            temperature = 1f
            candidateCount = 1
            topP = 1f
            topK = 64
            responseMimeType = "text/plain"
        }
        val safety: List<SafetySetting> = listOf(
            SafetySetting(HarmCategory.HARASSMENT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.HATE_SPEECH, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, BlockThreshold.MEDIUM_AND_ABOVE),
            SafetySetting(HarmCategory.DANGEROUS_CONTENT, BlockThreshold.MEDIUM_AND_ABOVE)
        )
        return with(viewModelClass) {
            val generativeModel = GenerativeModel(
                modelName = "gemini-1.5-flash-latest",
                apiKey= "AIzaSyCPt2sXVB5GRc99iLNclgpoWBFy4mpaszQ",
                generationConfig = config,
                safetySettings = safety
            )
            ChatViewModel(generativeModel)
        } as T
    }
}
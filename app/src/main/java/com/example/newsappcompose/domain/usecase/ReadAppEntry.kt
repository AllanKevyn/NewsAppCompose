package com.example.newsappcompose.domain.usecase

import android.text.BoringLayout
import com.example.newsappcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}
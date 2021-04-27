package com.aqube.ram.data

import com.aqube.ram.domain.models.SettingType
import com.aqube.ram.domain.models.Settings
import com.aqube.ram.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.*

import javax.inject.Inject

class SettingsRepositoryImp @Inject constructor(
    private val appVersion: String,
) : SettingsRepository {
    override suspend fun getSettings(nightMode: Boolean): Flow<List<Settings>> = flow {
        emit(getData(nightMode))
    }

    //This should be came from api but we don't have api so we are crating locally
    private fun getData(isNightMode: Boolean): List<Settings> {
        val settingList = mutableListOf<Settings>()
        settingList.add(Settings(1, SettingType.SWITCH, "Theme mode", "", isNightMode))
        settingList.add(Settings(2, SettingType.EMPTY, "Clear cache", ""))
        settingList.add(Settings(2, SettingType.TEXT, "App version", appVersion))
        return settingList
    }

}
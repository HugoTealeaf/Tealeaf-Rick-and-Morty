package com.aqube.ram.di

import com.aqube.ram.BuildConfig
import com.aqube.ram.data.repository.CharacterRemote
import com.aqube.ram.remote.api.CharacterService
import com.aqube.ram.remote.api.ServiceFactory
import com.aqube.ram.remote.repository.CharacterRemoteImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideBlogService(): CharacterService {
        return ServiceFactory.create(BuildConfig.DEBUG, "https://rickandmortyapi.com/api/")
    }

    @Provides
    @Singleton
    fun provideCharacterRemote(characterRepository: CharacterRemoteImp): CharacterRemote {
        return characterRepository
    }

}
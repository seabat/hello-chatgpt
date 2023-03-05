package dev.seabat.android.hellochatgpt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.seabat.android.hellochatgpt.data.repo.openai.OpenAiRepository
import dev.seabat.android.hellochatgpt.domain.contract.OpenAiRepositoryContract
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class OpenAiRepositoryContractModule {
    @Binds
    @Singleton
    abstract fun bindOpenAiRepositoryContract(
        openAiRepository: OpenAiRepository
    ): OpenAiRepositoryContract
}
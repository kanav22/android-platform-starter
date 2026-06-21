package dev.kanav.platform.feature.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kanav.platform.domain.repository.CatalogRepository
import dev.kanav.platform.domain.usecase.GetFeaturedItemsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetFeaturedItemsUseCase(
        repository: CatalogRepository,
    ): GetFeaturedItemsUseCase = GetFeaturedItemsUseCase(repository)
}

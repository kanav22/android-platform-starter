package dev.kanav.platform.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kanav.platform.data.repository.FakeCatalogRepository
import dev.kanav.platform.domain.repository.CatalogRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindCatalogRepository(
        impl: FakeCatalogRepository,
    ): CatalogRepository
}

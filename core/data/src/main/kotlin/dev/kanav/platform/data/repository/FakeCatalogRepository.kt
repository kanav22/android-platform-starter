package dev.kanav.platform.data.repository

import dev.kanav.platform.domain.model.CatalogItem
import dev.kanav.platform.domain.repository.CatalogRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeCatalogRepository @Inject constructor() : CatalogRepository {
    override suspend fun getFeaturedItems(): List<CatalogItem> = listOf(
        CatalogItem(
            id = "offline-first",
            title = "Offline-first",
            subtitle = "Cache-then-network with explicit sync boundaries",
        ),
        CatalogItem(
            id = "modular-architecture",
            title = "Modular architecture",
            subtitle = "Feature modules isolated behind domain contracts",
        ),
        CatalogItem(
            id = "quality-gates",
            title = "Quality gates",
            subtitle = "Unit tests, Detekt, and CI on every pull request",
        ),
    )
}

package dev.kanav.platform.domain.repository

import dev.kanav.platform.domain.model.CatalogItem

interface CatalogRepository {
    suspend fun getFeaturedItems(): List<CatalogItem>
}

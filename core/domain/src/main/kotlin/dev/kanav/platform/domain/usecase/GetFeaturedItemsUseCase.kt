package dev.kanav.platform.domain.usecase

import dev.kanav.platform.common.Result
import dev.kanav.platform.domain.model.CatalogItem
import dev.kanav.platform.domain.repository.CatalogRepository

class GetFeaturedItemsUseCase(
    private val repository: CatalogRepository,
) {
    suspend operator fun invoke(): Result<List<CatalogItem>> = try {
        Result.Success(repository.getFeaturedItems())
    } catch (exception: Exception) {
        Result.Error(exception.message ?: "Unable to load catalog items")
    }
}

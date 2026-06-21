package dev.kanav.platform.domain.usecase

import dev.kanav.platform.common.Result
import dev.kanav.platform.domain.model.CatalogItem
import dev.kanav.platform.domain.repository.CatalogRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetFeaturedItemsUseCaseTest {

    @Test
    fun invoke_returnsSuccessWithItems() = runTest {
        val useCase = GetFeaturedItemsUseCase(FakeCatalogRepository)

        val result = useCase()

        assertTrue(result is Result.Success)
        assertEquals(3, (result as Result.Success).data.size)
    }

    private object FakeCatalogRepository : CatalogRepository {
        override suspend fun getFeaturedItems(): List<CatalogItem> = listOf(
            CatalogItem("1", "Offline-first", "Cache-then-network data flows"),
            CatalogItem("2", "Modular boundaries", "Feature modules with clear contracts"),
            CatalogItem("3", "CI quality gates", "Tests and static analysis on every PR"),
        )
    }
}

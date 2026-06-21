package dev.kanav.platform.feature.home

import dev.kanav.platform.common.Result
import dev.kanav.platform.domain.model.CatalogItem
import dev.kanav.platform.domain.repository.CatalogRepository
import dev.kanav.platform.domain.usecase.GetFeaturedItemsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun loadItems_emitsCatalogItems() = runTest(dispatcher) {
        val repository = object : CatalogRepository {
            override suspend fun getFeaturedItems(): List<CatalogItem> = listOf(
                CatalogItem("1", "Testing", "ViewModel + use case boundaries"),
            )
        }
        val viewModel = HomeViewModel(GetFeaturedItemsUseCase(repository))

        viewModel.loadItems()
        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertFalse(state.isLoading)
        assertEquals(1, state.items.size)
        assertEquals("Testing", state.items.first().title)
    }

    @Test
    fun loadItems_emitsErrorWhenRepositoryFails() = runTest(dispatcher) {
        val repository = object : CatalogRepository {
            override suspend fun getFeaturedItems(): List<CatalogItem> {
                error("network down")
            }
        }
        val viewModel = HomeViewModel(GetFeaturedItemsUseCase(repository))

        viewModel.loadItems()
        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertFalse(state.isLoading)
        assertEquals("network down", state.errorMessage)
    }
}

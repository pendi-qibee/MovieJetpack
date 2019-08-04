package id.qibee.moviejetpack

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import id.qibee.moviejetpack.model.DataDummy
import id.qibee.moviejetpack.model.MovieItem
import id.qibee.moviejetpack.model.MovieResponse
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@RunWith(JUnit4::class)
class MovieListViewModelTest {


    // Executes tasks in the Architecture Components in the same thread
    @get:Rule
    @JvmField
    var instantExecutorRule = InstantTaskExecutorRule()


    @Mock
    internal var app: Application = Application()

    private lateinit var movieListViewModel: MovieListViewModel

    private val dataDummy = mock(DataDummy::class.java)

    @Spy
    private var dummyMovieList: List<MovieItem> = arrayListOf()

    @Rule
    @JvmField
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        movieListViewModel = MovieListViewModel(app)
        movieListViewModel.getDummyMovieList()
        movieListViewModel.observableDummyMovieList
    }

    @Test
    fun dataDummyTest() {
        assertNotNull(dummyMovieList)
        `when`(dataDummy.addDummyMovie()).thenReturn(dummyMovieList)



    }

    @Test
    fun `add data dummy test`() {
        dataDummy.addDummyMovie()
        `when`(movieListViewModel.dummyMovieList).thenReturn(dummyMovieList)

    }


}
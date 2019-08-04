package id.qibee.moviejetpack

import android.app.Application
import id.qibee.moviejetpack.model.DataDummy
import id.qibee.moviejetpack.model.MovieItem
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@RunWith(JUnit4::class)
class MovieListViewModelTest {

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

    @Test
    fun `check data size`(){
        assertEquals(2, movieListViewModel.dummyMovieList.size)
    }
}
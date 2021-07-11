package asensio.cristina.androidstudyguide.articlelist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import asensio.cristina.androidstudyguide.CoroutinesTestRule
import asensio.cristina.androidstudyguide.models.Article
import asensio.cristina.androidstudyguide.util.HtmlString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticleListViewModelTest {

    private val testRobot = ArticleListViewModelRobot()

    @Rule
    val instantTaskExecutiveRule = InstantTaskExecutorRule()

    @JvmField
    @Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun successfulRequest() {
        val testArticles = listOf(
            Article(htmlTitle = HtmlString("Test title"))
        )

        testRobot
            .mockArticles(testArticles)
            .buildViewModel()
            .assertViewState(
                expectedViewState = ArticleListViewState.success(testArticles)
            )
    }
}
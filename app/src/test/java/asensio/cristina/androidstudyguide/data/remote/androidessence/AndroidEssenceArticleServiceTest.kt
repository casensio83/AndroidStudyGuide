package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.models.Article
import asensio.cristina.androidstudyguide.util.HtmlString
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class AndroidEssenceArticleServiceTest {

    private val testRobot = AndroidEssenceArticleServiceTestRobot()

    @ExperimentalCoroutinesApi
    @Test
    fun fetchValidAccountList() = runBlockingTest {
        val mockFeed = AndroidEssenceFeed(
            items = listOf(
                AndroidEssenceFeedItem(
                    title = "Test Title",
                    author = AndroidEssenceAuthor(
                        name = "Adam McNeilly"
                    ),
                    link = AndroidEssenceLink(
                        href = "Test URL"
                    )
                )
            )
        )

        val expectedArticles = listOf(
            Article(
                htmlTitle = HtmlString("Test Title"),
                authorName = "Adam McNeilly",
                url = "Test URL"
            )
        )

        testRobot
            .mockFeed(mockFeed)
            .buildService()
            .assertFetchedArticles(expectedArticles)
    }

    @Test
    fun fetchArticlesWithOneBookmarked() = runBlockingTest {
        val testUrl = "Test URL"

        val mockFeed = AndroidEssenceFeed(
            items = listOf(
                AndroidEssenceFeedItem(
                    title = "Test Title",
                    author = AndroidEssenceAuthor(
                        name = "Adam McNeilly"
                    ),
                    link = AndroidEssenceLink(
                        href = testUrl
                    )
                )
            )
        )

        val expectedArticles = listOf(
            Article(
                htmlTitle = HtmlString("Test Title"),
                authorName = "Adam McNeilly",
                url = testUrl
            )
        )

        testRobot
            .mockFeed(mockFeed)
            .buildService()
            .assertFetchedArticles(expectedArticles)
    }

}
package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.models.Article
import com.google.common.truth.Truth.assertThat

class AndroidEssenceArticleServiceTestRobot {
    private val fakeApi = FakeAndroidEssenceRetrofitAPI()
    private lateinit var service: AndroidEssenceArticleService

    fun buildService() = apply {
        this.service = AndroidEssenceArticleService(
            api = fakeApi
        )
    }

    fun mockFeed(feed: AndroidEssenceFeed) = apply {
        fakeApi.setMockedFeed(feed)
    }

    suspend fun assertFetchedArticles(expectedArticles: List<Article>) = apply {
        val actualArticles = service.fetchArticles()
        assertThat(actualArticles).isEqualTo(expectedArticles)
    }
}
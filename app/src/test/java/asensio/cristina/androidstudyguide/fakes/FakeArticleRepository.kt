package asensio.cristina.androidstudyguide.fakes

import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article

class FakeArticleRepository : ArticleRepository {
    private var mockedArticles: List<Article> = emptyList()
    private var fetchArticlesCallCount = 0

    override suspend fun fetchArticles(): List<Article> {
        fetchArticlesCallCount++
        return mockedArticles
    }

    fun setMockedArticles(articles: List<Article>) {
        this.mockedArticles = articles
    }

    fun getFetchedArticlesCallCount(): Int {
        return fetchArticlesCallCount
    }
}
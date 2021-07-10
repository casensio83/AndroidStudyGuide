package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article

class AndroidEssenceArticleService (
    private val api: AndroidEssenceRetrofitAPI
) : ArticleRepository {
    override suspend fun fetchArticles(): List<Article> {
        return api.getFeed().items.map(AndroidEssenceFeedItem::toArticle)
    }
}
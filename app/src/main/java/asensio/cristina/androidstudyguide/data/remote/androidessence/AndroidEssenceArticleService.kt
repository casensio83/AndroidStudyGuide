package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article

class AndroidEssenceArticleService(
    private val api: AndroidEssenceRetrofitAPI
) : ArticleRepository {
    override suspend fun fetchArticles(): List<Article> {
        return api.getFeed().items.map(AndroidEssenceFeedItem::toArticle)
    }
}

private fun AndroidEssenceFeedItem.toArticle(): Article {
    return Article(
        title = this.title,
        authorName = this.author.name,
        url = this.url
    )
}
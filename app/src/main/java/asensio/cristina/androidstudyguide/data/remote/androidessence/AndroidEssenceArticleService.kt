package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article
import asensio.cristina.androidstudyguide.util.HtmlString

class AndroidEssenceArticleService(
    private val api: AndroidEssenceRetrofitAPI
) : ArticleRepository {
    override suspend fun fetchArticles(): List<Article> {
        return api.getFeed().items?.map(AndroidEssenceFeedItem::toArticle).orEmpty()
    }
}

/**
 * TODO: If any of these networking values are null, we should throw an error
 *  so we're aware but we've decided not to crash
 */
private fun AndroidEssenceFeedItem.toArticle(): Article {
    return Article(
        htmlTitle = HtmlString(this.title.orEmpty()),
        authorName = this.author?.name.orEmpty(),
        url = this.link?.href.orEmpty()
    )
}
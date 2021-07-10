package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article
import asensio.cristina.androidstudyguide.util.HtmlString

class AndroidEssenceArticleService(
    private val api: AndroidEssenceRetrofitAPI
) : ArticleRepository {
    override suspend fun fetchArticles(): List<Article> {
        return api.getFeed().items.map(AndroidEssenceFeedItem::toArticle)
    }
}

private fun AndroidEssenceFeedItem.toArticle(): Article {
    return Article(
        htmlTitle = HtmlString(this.title),
        authorName = this.author.name,
        url = this.link.href.orEmpty()
    )
}
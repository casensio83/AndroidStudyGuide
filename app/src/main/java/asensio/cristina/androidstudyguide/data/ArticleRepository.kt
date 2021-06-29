package asensio.cristina.androidstudyguide.data

import asensio.cristina.androidstudyguide.models.Article

/**
 * Represents any source of articles to be displayed
 */
interface ArticleRepository {
    fun fetchArticles(): List<Article>
}
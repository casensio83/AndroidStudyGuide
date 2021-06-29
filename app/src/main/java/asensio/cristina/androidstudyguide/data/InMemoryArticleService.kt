package asensio.cristina.androidstudyguide.data

import asensio.cristina.androidstudyguide.models.Article

class InMemoryArticleService: ArticleRepository {

    override fun fetchArticles(): List<Article> {
        return listOf(
            Article(
                title = "Article One",
                authorName = "Adam McNeilly",
                url = ""
            ),
            Article(
                title = "Article Two",
                authorName = "Adam McNeilly",
                url = ""
            ),
            Article(
                title = "Article Three",
                authorName = "Adam McNeilly",
                url = ""
            ),
            Article(
                title = "Article Four",
                authorName = "Adam McNeilly",
                url = ""
            )
        )
    }
}
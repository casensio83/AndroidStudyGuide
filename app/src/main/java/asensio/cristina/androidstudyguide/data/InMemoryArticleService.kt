package asensio.cristina.androidstudyguide.data

import asensio.cristina.androidstudyguide.models.Article

class InMemoryArticleService: ArticleRepository {

    override fun fetchArticles(): List<Article> {
        return listOf(
            Article(
                title = "Unit Testing Custom Lint Checks",
                authorName = "Adam McNeilly",
                url = "https://androidessence.com/unit-testing-custom-lint-checks"
            ),
            Article(
                title = "Enforcing Custom View Usage With Android Lint",
                authorName = "Adam McNeilly",
                url = "https://androidessence.com/enforce-custom-views-with-lint"
            ),
            Article(
                title = "Getting Started With Test Driven Development",
                authorName = "Adam McNeilly",
                url = "https://androidessence.com/test-driven-development"
            ),
            Article(
                title = "MVWTF: Demystifying Architecture Patterns",
                authorName = "Adam McNeilly",
                url = "https://androidessence.com/mvwtf"
            )
        )
    }
}
package asensio.cristina.androidstudyguide.data

import asensio.cristina.androidstudyguide.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InMemoryArticleService : ArticleRepository {

    override suspend fun fetchArticles(): List<Article> {
        // Run fetch articles in the background
        return withContext(Dispatchers.IO) {
            listOf(
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
}
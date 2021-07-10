package asensio.cristina.androidstudyguide.data

import asensio.cristina.androidstudyguide.models.Article
import asensio.cristina.androidstudyguide.util.HtmlString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InMemoryArticleService : ArticleRepository {

    override suspend fun fetchArticles(): List<Article> {
        // Run fetch articles in the background
        return withContext(Dispatchers.IO) {
            listOf(
                Article(
                    htmlTitle = HtmlString("Unit Testing Custom Lint Checks"),
                    authorName = "Adam McNeilly",
                    url = "https://androidessence.com/unit-testing-custom-lint-checks"
                ),
                Article(
                    htmlTitle = HtmlString("Enforcing Custom View Usage With Android Lint"),
                    authorName = "Adam McNeilly",
                    url = "https://androidessence.com/enforce-custom-views-with-lint"
                ),
                Article(
                    htmlTitle = HtmlString("Getting Started With Test Driven Development"),
                    authorName = "Adam McNeilly",
                    url = "https://androidessence.com/test-driven-development"
                ),
                Article(
                    htmlTitle = HtmlString("MVWTF: Demystifying Architecture Patterns"),
                    authorName = "Adam McNeilly",
                    url = "https://androidessence.com/mvwtf"
                )
            )
        }
    }
}
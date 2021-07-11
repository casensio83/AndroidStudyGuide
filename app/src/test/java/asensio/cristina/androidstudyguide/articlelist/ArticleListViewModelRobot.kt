package asensio.cristina.androidstudyguide.articlelist

import asensio.cristina.androidstudyguide.fakes.FakeArticleRepository
import asensio.cristina.androidstudyguide.models.Article
import asensio.cristina.androidstudyguide.testObserver
import com.google.common.truth.Truth.assertThat

class ArticleListViewModelRobot {
    private lateinit var viewModel: ArticleListViewModel
    private val fakeRepository = FakeArticleRepository()

    fun mockArticles(articles: List<Article>) = apply {
        fakeRepository.setMockedArticles(articles)
    }

    fun buildViewModel() = apply {
        viewModel = ArticleListViewModel(
            articleRepository = fakeRepository
        )
    }

    fun assertViewState(expectedViewState: ArticleListViewState) = apply {
        val actualViewState = viewModel.state.testObserver().observedValue
        assertThat(actualViewState).isEqualTo(expectedViewState)
    }
}
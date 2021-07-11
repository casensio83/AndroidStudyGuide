package asensio.cristina.androidstudyguide.articlelist

import asensio.cristina.androidstudyguide.models.Article

data class ArticleListViewState(
    val showLoading: Boolean,
    val showArticles: Boolean,
    val showError: Boolean,
    val articles: List<Article> = emptyList()
) {
    companion object {
        fun loading(): ArticleListViewState {
            return ArticleListViewState(
                showLoading = true,
                showArticles = false,
                showError = false
            )
        }

        fun success(articlesList: List<Article>): ArticleListViewState {
            return ArticleListViewState(
                showLoading = false,
                showArticles = true,
                showError = false,
                articles = articlesList
            )
        }

        fun onError(): ArticleListViewState {
            return ArticleListViewState(
                showLoading = false,
                showArticles = false,
                showError = true
            )
        }
    }
}
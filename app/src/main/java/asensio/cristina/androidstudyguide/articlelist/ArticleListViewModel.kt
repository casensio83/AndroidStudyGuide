package asensio.cristina.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    // Only this class can manipulate articles, not other classes
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articles: LiveData<List<Article>> = _articles

    init {
        val fetchedArticles = articleRepository.fetchArticles()
        _articles.value = fetchedArticles
    }


}
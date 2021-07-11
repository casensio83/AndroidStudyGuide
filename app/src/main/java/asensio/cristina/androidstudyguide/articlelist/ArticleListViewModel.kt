package asensio.cristina.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import asensio.cristina.androidstudyguide.data.ArticleRepository
import kotlinx.coroutines.launch

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    private val _state: MutableLiveData<ArticleListViewState> = MutableLiveData()
    val state: LiveData<ArticleListViewState> = _state

    // Only this class can manipulate articles, not other classes
//    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
//    val articles: LiveData<List<Article>> = _articles

    init {

        viewModelScope.launch {
            _state.value = ArticleListViewState.loading()

            val fetchedArticles = articleRepository.fetchArticles()
            _state.value = ArticleListViewState.success(fetchedArticles)
            //_articles.value = fetchedArticles
        }

    }


}
package asensio.cristina.androidstudyguide.articlelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArticleListViewModel(
    articleRepository: ArticleRepository
) : ViewModel() {

    // Only this class can manipulate articles, not other classes
    private val _articles: MutableLiveData<List<Article>> = MutableLiveData()
    val articles: LiveData<List<Article>> = _articles

    init {

        viewModelScope.launch {

            // Run fetch articles in the background
            val fetchedArticles = withContext(Dispatchers.IO) {
                articleRepository.fetchArticles()
            }

            _articles.value = fetchedArticles
        }

    }


}
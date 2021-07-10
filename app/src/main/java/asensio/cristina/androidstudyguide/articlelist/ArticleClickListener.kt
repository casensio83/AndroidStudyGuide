package asensio.cristina.androidstudyguide.articlelist

import asensio.cristina.androidstudyguide.models.Article

interface ArticleClickListener {
    fun onArticleClick(article: Article)
}
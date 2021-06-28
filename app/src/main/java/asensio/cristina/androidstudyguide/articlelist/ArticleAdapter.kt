package asensio.cristina.androidstudyguide.articlelist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import asensio.cristina.androidstudyguide.databinding.ListItemArticleBinding
import asensio.cristina.androidstudyguide.models.Article

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var articles: List<Article> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemArticleBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bindArticle(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(binding: ListItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val titleTextView: TextView = binding.articleTitle
        private val authorTextView: TextView = binding.articleAuthor

        fun bindArticle(article: Article) {
            titleTextView.text = article.title
            authorTextView.text = article.authorName
        }
    }

}
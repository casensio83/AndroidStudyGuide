package asensio.cristina.androidstudyguide.articlelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import asensio.cristina.androidstudyguide.databinding.ListItemArticleBinding
import asensio.cristina.androidstudyguide.models.Article

class ArticleAdapter(private val articleClickListener: ArticleClickListener) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    var articles: List<Article> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemArticleBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding, articleClickListener)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bindArticle(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(
        private val binding: ListItemArticleBinding,
        private val articleClickListener: ArticleClickListener
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
//        private val titleTextView: TextView = binding.articleTitle
//        private val authorTextView: TextView = binding.articleAuthor

        init {
            binding.root.setOnClickListener(this)
        }

        fun bindArticle(article: Article) {
            binding.article = article
            binding.executePendingBindings()
//            titleTextView.text = article.title
//            authorTextView.text = article.authorName
        }

        override fun onClick(view: View?) {
            val article = binding.article

            if (article != null) {
                articleClickListener.onArticleClick(article)
            }

        }
    }

}
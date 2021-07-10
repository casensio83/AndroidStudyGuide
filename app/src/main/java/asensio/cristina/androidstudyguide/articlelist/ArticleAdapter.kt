package asensio.cristina.androidstudyguide.articlelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import asensio.cristina.androidstudyguide.R
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

        private val titleTextView: TextView = binding.articleTitle
        private val authorTextView: TextView = binding.articleAuthor
        private var article: Article? = null

        init {
            binding.root.setOnClickListener(this)
        }

        fun bindArticle(article: Article) {
            // Data binding
//            binding.article = article
//            binding.executePendingBindings()

            // View binding
            this.article = article
            titleTextView.text = article.htmlTitle.getSpanned()
            authorTextView.text = itemView.context.getString(R.string.by_author, article.authorName)
        }

        override fun onClick(view: View?) {
            // Data binding
            //val article = binding.article
//            if (article != null) {
//                articleClickListener.onArticleClick(article)
//            }

            article?.let(articleClickListener::onArticleClick)

        }
    }

}
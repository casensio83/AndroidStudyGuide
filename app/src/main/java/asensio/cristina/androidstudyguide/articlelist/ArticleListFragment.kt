package asensio.cristina.androidstudyguide.articlelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.data.InMemoryArticleService
import asensio.cristina.androidstudyguide.databinding.FragmentArticleListBinding
import asensio.cristina.androidstudyguide.models.Article


class ArticleListFragment : Fragment(), ArticleClickListener {

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var adapter: ArticleAdapter

    private val articleRepository: ArticleRepository = InMemoryArticleService()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = ArticleAdapter(this)
        binding = FragmentArticleListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.articles = articleRepository.fetchArticles()
    }

    private fun setupRecyclerView() {
        binding.articleList.adapter = adapter
        binding.articleList.layoutManager = LinearLayoutManager(context)

        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.articleList.addItemDecoration(dividerItemDecoration)
    }

    override fun onArticleClick(article: Article) {
        val uri = Uri.parse(article.url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

}
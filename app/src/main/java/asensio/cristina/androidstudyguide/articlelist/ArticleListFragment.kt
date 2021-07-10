package asensio.cristina.androidstudyguide.articlelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import asensio.cristina.androidstudyguide.data.ArticleRepository
import asensio.cristina.androidstudyguide.data.remote.androidessence.AndroidEssenceArticleService
import asensio.cristina.androidstudyguide.data.remote.androidessence.AndroidEssenceRetrofitAPI
import asensio.cristina.androidstudyguide.databinding.FragmentArticleListBinding
import asensio.cristina.androidstudyguide.models.Article


class ArticleListFragment : Fragment(), ArticleClickListener {

    private lateinit var binding: FragmentArticleListBinding
    private lateinit var adapter: ArticleAdapter
    private lateinit var viewModel: ArticleListViewModel

    private val articleListViewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            val repository: ArticleRepository = InMemoryArticleService()


            val repository: ArticleRepository = AndroidEssenceArticleService(
                api = AndroidEssenceRetrofitAPI.getDefaultApi()
            )

            @Suppress("UNCHECKED_CAST")
            return ArticleListViewModel(
                articleRepository = repository
            ) as T

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Checks if a viewmodel already exists for this fragment and if not it will
        // create a new one
        viewModel = ViewModelProvider(
            this,
            articleListViewModelFactory
        ).get(ArticleListViewModel::class.java)
    }

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

        subscribeToViewModel()

    }

    private fun subscribeToViewModel() {
        viewModel.articles.observe(viewLifecycleOwner, { articles ->
            adapter.articles = articles
        })
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
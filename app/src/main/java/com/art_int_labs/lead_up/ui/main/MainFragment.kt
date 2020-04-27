
package com.art_int_labs.lead_up.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.art_int_labs.lead_up.R
import com.art_int_labs.lead_up.data.db.entity.News
import com.art_int_labs.lead_up.ui.base.ScopedFragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class MainFragment : ScopedFragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val mainViewModelFactory : MainViewModelFactory by instance()
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, mainViewModelFactory)
            .get(MainViewModel::class.java)

        bindUI()
    }


    private fun bindUI() = launch{
        val news = viewModel.news.await()
        val courses = viewModel.news.await()
        news.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            initRecyclerView(it.toNews())
        })

        courses.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
        })


    }

    private fun List<News>.toNews():List<NewsSimpleItem>{
        val list = mutableListOf<NewsSimpleItem>()
        this.forEach {
            val new = NewsSimpleItem(it)
            list.add(new)
        }
        return list
    }

    private fun initRecyclerView(items:List<NewsSimpleItem>){
        val groupAdapter = GroupAdapter<GroupieViewHolder>().apply {
            addAll(items)
        }
        newsViewPager.apply {
            adapter = groupAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER)
        }

        newsViewPager.setPageTransformer(CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
            addTransformer(CustomTransformer())
        })
    }

    inner class CustomTransformer: ViewPager2.PageTransformer {
        override fun transformPage(page: View, position: Float) {
            val r = 1 - Math.abs(position)
            //  page.translationY = - Math.abs(position) * 110f
            page.scaleY = 0.85f + r *0.25f
            page.scaleX = 0.85f + r *0.25f
        }
    }


}

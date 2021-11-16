package com.ilabank.practical.mvvm.ui.main.view

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.MarginPageTransformer
import com.ilabank.practical.mvvm.R
import com.ilabank.practical.mvvm.ui.main.adapter.ListAdapter
import com.ilabank.practical.mvvm.ui.main.adapter.PagerAdapter
import com.ilabank.practical.mvvm.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.ilabank.practical.mvvm.data.model.Animal

class MainActivity : AppCompatActivity(),
    SearchView.OnQueryTextListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()

    }

    private fun setupUI() {
        searchView.setOnQueryTextListener(this)

        pagerAdapter = PagerAdapter(arrayListOf())
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 1

        viewPager.apply {
            clipToPadding = false   // allow full width shown with padding
            clipChildren = false    // allow left/right item is not clipped
            offscreenPageLimit = 1  // make sure left/right item is rendered
        }

        val offsetPx = 30.dpToPx(resources.displayMetrics)
        viewPager.setPadding(0, 0, offsetPx, 0)

        val pageMarginPx = 10.dpToPx(resources.displayMetrics)
        val marginTransformer = MarginPageTransformer(pageMarginPx)
        viewPager.setPageTransformer(marginTransformer)

        TabLayoutMediator(into_tab_layout, viewPager)
        { tab, position -> }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                searchView.setQuery("", false)
                searchView.clearFocus()
                renderAnimalBreedsList(arrayListOf())
                mainViewModel.fetchAnimalBreeds(pagerAdapter.getData(position))
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter(arrayListOf())
        recyclerView.adapter = listAdapter
    }

    fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

    private fun setupObserver() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.animal.observe(this, {
            renderAnimalList(it)
        })
        mainViewModel.animalBreeds.observe(this, {
            renderAnimalBreedsList(it)
        })
    }

    private fun renderAnimalList(users: List<Animal>) {
        pagerAdapter.addData(users)
        pagerAdapter.notifyDataSetChanged()
    }

    private fun renderAnimalBreedsList(users: List<Animal>) {
        listAdapter.addData(users)
        listAdapter.notifyDataSetChanged()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        listAdapter.filter.filter(newText)
        return false
    }
}

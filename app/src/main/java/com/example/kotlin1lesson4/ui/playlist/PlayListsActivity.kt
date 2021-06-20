package com.example.kotlin1lesson4.ui.playlist

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin1lesson4.R
import com.example.kotlin1lesson4.`object`.Constants
import com.example.kotlin1lesson4.base.BaseActivity
import com.example.kotlin1lesson4.model.playlist.Items
import com.example.kotlin1lesson4.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_play_lists.*

class PlayListsActivity : BaseActivity(R.layout.activity_play_lists), OnItemClickListener {

    private val viewModel : PlayListsViewModel by lazy {
        ViewModelProvider(this).get(PlayListsViewModel::class.java)
    }

    private val adapter : PlayListsAdapter = PlayListsAdapter(this)

    override fun setupUi() {
        rv_pl_main.adapter = adapter
    }

    override fun setupLiveData() {
        viewModel.fetchAllPlayLists().observe(this, Observer{
            it?.items?.let {
                adapter.setItems(it)
            }
        })
    }

    override fun showDisconnectState() {
    }

    override fun onClick(items: Items) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(Constants.VIDEO_ID, items)
        })
    }

}
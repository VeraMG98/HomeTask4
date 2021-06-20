package com.example.kotlin1lesson4.ui.detail

import android.widget.Toast
import com.example.kotlin1lesson4.R
import com.example.kotlin1lesson4.`object`.Constants
import com.example.kotlin1lesson4.base.BaseActivity
import com.example.kotlin1lesson4.model.playlist.Items

class DetailActivity : BaseActivity(R.layout.activity_detail) {
    override fun setupLiveData() {
    }

    override fun setupUi() {
        val  item : Items = intent.getSerializableExtra(Constants.VIDEO_ID) as Items
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
    }

    override fun showDisconnectState() {
    }

}
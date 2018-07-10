package com.example.playuitest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LifeAdapter(context: Context) : RecyclerView.Adapter<LifeAdapter.MyHolder>() {
    var mContext:Context ?= null
    init {
        mContext = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view =  LayoutInflater.from(mContext).inflate(R.layout.item_show,parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

    }
    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}

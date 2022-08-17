package com.otsembo.buffoonapp

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otsembo.buffoonapp.userlist.UserAdapter

@BindingAdapter("numberData")
fun TextView.setNumberData(id: Long) {
    this.text = id.toString()
}

@BindingAdapter("userAdapter")
fun RecyclerView.setUserData(userAdapter: UserAdapter) {
    this.adapter = userAdapter
}

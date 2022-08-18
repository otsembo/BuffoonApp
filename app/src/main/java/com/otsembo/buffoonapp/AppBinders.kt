package com.otsembo.buffoonapp

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otsembo.buffoonapp.model.User
import com.otsembo.buffoonapp.userlist.UserAdapter

@BindingAdapter("numberData")
fun EditText.setNumberData(id: Long) {
    this.setText(id.toString())
}

@BindingAdapter("numberDataText")
fun TextView.setNumberData(id: Long) {
    this.text = id.toString()
}

@BindingAdapter("userAdapter")
fun RecyclerView.setUserData(userAdapter: UserAdapter) {
    this.adapter = userAdapter
}

@BindingAdapter("userList")
fun RecyclerView.setUserDataFromList(userList: List<User>) {
    val adapter = UserAdapter()
    adapter.submitList(userList)
    this.adapter = adapter
}

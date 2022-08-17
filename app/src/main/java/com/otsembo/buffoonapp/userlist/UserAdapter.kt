package com.otsembo.buffoonapp.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.otsembo.buffoonapp.databinding.UserItemBinding
import com.otsembo.buffoonapp.model.User

class UserAdapter : ListAdapter<User, UserAdapter.UserHolder>(UserDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bindData(currentList[position])
    }

    class UserHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }

        companion object {
            fun from(container: ViewGroup): UserHolder {
                val inflater = LayoutInflater.from(container.context)
                return UserHolder(
                    UserItemBinding.inflate(inflater, container, false)
                )
            }
        }
    }
}

class UserDiffCallBack : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}

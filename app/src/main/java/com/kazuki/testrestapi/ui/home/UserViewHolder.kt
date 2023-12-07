package com.kazuki.testrestapi.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.kazuki.testrestapi.databinding.ItemUserBinding
import com.kazuki.testrestapi.model.User

/**
 * penamaan class harus camelCase
 * untuk constructor bisa pake langsung () atau class ClassName constructor()
 * untuk isi dari contruktor harus val/var, dan juga harus ada tipedata nya
 * di akhir class juga harus di kasih tipe data ( return dari class itu tipedata nya apa) mengunaan tanda ':'
 */
class UserViewHolder(private val view: ItemUserBinding): RecyclerView.ViewHolder(view.root) {
    public fun bind(user: User) {
        view.userName.text = user.name
        view.userEmail.text = user.email
        view.userPhone.text = user.phone
        // if use costume photo, use this
        // view.userPhoto.setImageResource(user.photo)
    }
}
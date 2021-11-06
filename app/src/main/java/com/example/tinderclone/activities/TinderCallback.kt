package com.example.tinderclone.activities

import com.google.firebase.database.DatabaseReference

interface TinderCallback {

    fun onSignout()
    fun onGetUserId():String
    fun getUserDatabase():DatabaseReference
    fun getChatDatabase():DatabaseReference
    fun profileComplete()
    fun startActivityForPhoto()
}


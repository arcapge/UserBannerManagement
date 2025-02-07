package com.cg.arpisinh.bannerandusermanagement.repositories

import com.cg.arpisinh.bannerandusermanagement.models.Banner
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore

class BannerRepository {
    private val firestore = FirebaseFirestore.getInstance()

    fun addBanner(bannerData: Banner, callback: (Boolean) -> Unit) {
        firestore.collection("banners").add(bannerData)
            .addOnCompleteListener { task -> callback(task.isSuccessful) }
    }

    fun getActiveBanners(callback: (List<Banner>) -> Unit) {
        firestore.collection("banners").whereGreaterThan("end_date", Timestamp.now())
            .get().addOnSuccessListener { documents ->
                val banners = documents.map { it.toObject(Banner::class.java) }
                callback(banners)
            }
    }
}

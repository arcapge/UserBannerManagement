package com.cg.arpisinh.bannerandusermanagement.repositories

import com.cg.arpisinh.bannerandusermanagement.models.Profile
import com.google.firebase.firestore.FirebaseFirestore

class ProfileRepository {
    private val firestore = FirebaseFirestore.getInstance()

    fun getPendingProfiles(callback: (List<Profile>) -> Unit) {
        firestore.collection("profiles").whereEqualTo("admin_approved", false)
            .get().addOnSuccessListener { documents ->
                val profiles = documents.map { it.toObject(Profile::class.java) }
                callback(profiles)
            }
    }

    fun updateProfileStatus(profileId: String, approved: Boolean, callback: (Boolean) -> Unit) {
        firestore.collection("profiles").document(profileId)
            .update("admin_approved", approved)
            .addOnCompleteListener { task -> callback(task.isSuccessful) }
    }

    fun addProfile(profileData: Profile, callback: (Boolean) -> Unit) {
        firestore.collection("profiles").add(profileData)
            .addOnCompleteListener { task -> callback(task.isSuccessful) }
    }
}

package com.cg.arpisinh.bannerandusermanagement.repositories

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class ContactRepository {
    private val firestore = FirebaseFirestore.getInstance()

    fun requestContactAccess(userId: String, profileId: String, callback: (Boolean) -> Unit) {
        val request = hashMapOf(
            "requester_id" to userId,
            "profile_id" to profileId,
            "approved" to false,
            "requested_at" to FieldValue.serverTimestamp()
        )
        firestore.collection("contact_requests").add(request)
            .addOnCompleteListener { task -> callback(task.isSuccessful) }
    }

    fun updateContactRequestStatus(requestId: String, approved: Boolean, callback: (Boolean) -> Unit) {
        firestore.collection("contact_requests").document(requestId)
            .update("approved", approved)
            .addOnCompleteListener { task -> callback(task.isSuccessful) }
    }
}

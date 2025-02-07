package com.cg.arpisinh.bannerandusermanagement.repositories

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class BroadcastRepository {
    private val firestore = FirebaseFirestore.getInstance()

    fun sendBroadcast(message: String, callback: (Boolean) -> Unit) {
        val broadcast = hashMapOf(
            "message" to message,
            "sent_at" to FieldValue.serverTimestamp()
        )
        firestore.collection("broadcasts").add(broadcast)
            .addOnCompleteListener { task -> callback(task.isSuccessful) }
    }

    fun getBroadcasts(callback: (List<String>) -> Unit) {
        firestore.collection("broadcasts").get()
            .addOnSuccessListener { documents ->
                val messages = documents.map { it.getString("message") ?: "" }
                callback(messages)
            }
    }
}

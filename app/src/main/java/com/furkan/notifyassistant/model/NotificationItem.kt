package com.furkan.notifyassistant.model

/**
 * Simple data holder representing a notification shown in the UI.  In a full
 * implementation this would map to a Room entity persisted in SQLite.  For
 * demonstration purposes the app populates the list with a single example.
 */
data class NotificationItem(
    val app: String,
    val title: String,
    val text: String,
    val time: String
)

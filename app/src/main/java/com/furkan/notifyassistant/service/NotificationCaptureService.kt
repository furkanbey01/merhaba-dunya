package com.furkan.notifyassistant.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

/**
 * A basic implementation of NotificationListenerService that simply logs
 * notifications as they are posted or removed.  In a full implementation this
 * service would persist the notification details to a database so they can be
 * displayed in the UI.  Note that the service must be explicitly enabled by
 * the user in system settings before it will receive callbacks.
 */
class NotificationCaptureService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn?.let {
            val extras = it.notification.extras
            val title = extras.getString(android.app.Notification.EXTRA_TITLE) ?: ""
            val text = extras.getString(android.app.Notification.EXTRA_TEXT) ?: ""
            Log.d(TAG, "Notification posted from ${it.packageName}: $title - $text")
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        sbn?.let {
            Log.d(TAG, "Notification removed from ${it.packageName}")
        }
    }

    companion object {
        private const val TAG = "NotificationCapture"
    }
}

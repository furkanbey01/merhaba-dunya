package com.furkan.notifyassistant.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.furkan.notifyassistant.R
import com.furkan.notifyassistant.model.NotificationItem

/**
 * Basic RecyclerView adapter for showing a list of notifications.  The adapter
 * uses a view holder pattern and inflates the item layout defined in
 * res/layout/item_notification.xml.  It intentionally avoids more complex
 * features such as diffing or click callbacks to keep the example self‑contained.
 */
class NotificationAdapter(private val items: List<NotificationItem>) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.app.text = item.app
        holder.title.text = item.title
        holder.text.text = item.text
        holder.time.text = item.time
    }

    override fun getItemCount(): Int = items.size

    /**
     * Simple view holder storing references to TextView widgets.  This avoids
     * repeatedly calling findViewById during binding and improves scrolling
     * performance.  Additional views can be added here as the UI evolves.
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val app: TextView = itemView.findViewById(R.id.tvApp)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val text: TextView = itemView.findViewById(R.id.tvText)
        val time: TextView = itemView.findViewById(R.id.tvTime)
    }
}

data class quickView_dashboardModel(
    val title: String,
    val activityClass: Class<*>? = null, // Nullable for URL-based navigation
    val url: String? = null // Add this for URL navigation
)

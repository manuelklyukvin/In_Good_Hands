package manuelklyukvin.in_good_hands.posts.adapters

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

class MapAdapterImpl(private val context: Context) : MapAdapter {
    override fun openMap(address: String) {
        val uri = "geo:0,0?q=$address".toUri()
        val intent = Intent(Intent.ACTION_VIEW, uri).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}
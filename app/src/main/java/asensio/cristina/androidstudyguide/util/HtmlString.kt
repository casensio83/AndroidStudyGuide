package asensio.cristina.androidstudyguide.util

import android.text.Html
import android.text.Spanned

// Inline is like compiler optimization. This is not a new class added
inline class HtmlString(private val input: String) {
    fun getSpanned(): Spanned {
        return Html.fromHtml(input, Html.FROM_HTML_MODE_LEGACY)
    }
}
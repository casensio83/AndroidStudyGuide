package asensio.cristina.androidstudyguide.models

import asensio.cristina.androidstudyguide.util.HtmlString

/**
 * @property(htmlTitle) Some data sources for articles may include HTML characters,
 * so we need the [HtmlString] class to do the necessary decoding before displaying this on the UI.
 * Any one who creates an instance of Article wil lneed to encode their title first
 */
data class Article(
    val htmlTitle: HtmlString = HtmlString(""),
    val authorName: String = "",
    val url: String = ""
)
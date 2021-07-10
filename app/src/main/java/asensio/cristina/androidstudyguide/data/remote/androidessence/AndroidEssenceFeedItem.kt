package asensio.cristina.androidstudyguide.data.remote.androidessence

import asensio.cristina.androidstudyguide.models.Article
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "entry", strict = false)
data class AndroidEssenceFeedItem(

    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String = ""

) {
    fun toArticle(): Article {
        return Article(
            title = this.title,
            authorName = "",
            url = ""
        )
    }
}

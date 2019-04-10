package ar.com.wolox.android.example.model

data class News(val id: Int, val userId: Int, val createdAt: String, val title: String,
           val picture: String, val text: String, val likes: List<Int>) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is News) {
            return false
        }

        return this.id == other.id
    }

    fun hasSameContent(other: News): Boolean {
        return this == other || (this.title == other.title && this.text == other.text &&
                this.createdAt == other.createdAt && this.picture == other.picture)
    }
}
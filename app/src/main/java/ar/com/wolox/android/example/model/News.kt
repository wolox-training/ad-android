package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("title") val title: String,
    @SerializedName("picture") val picture: String,
    @SerializedName("text") val text: String,
    @SerializedName("likes") val likes: List<Int>
) {

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

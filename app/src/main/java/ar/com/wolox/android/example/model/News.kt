package ar.com.wolox.android.example.model

// TODO FOR NEXT PR (Backend): this is an example of News Model, improve it later!
class News(val title: String, val description: String) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is News) {
            return false
        }

        return other.title == this.title && other.description == this.description
    }
}
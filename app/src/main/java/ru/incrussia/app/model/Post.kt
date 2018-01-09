package ru.incrussia.app.model

import com.google.gson.annotations.SerializedName

/**
 * Post info from website
 *
 * Created by Sergey Elizarov elizarov1988@gmail.com
 *    on 02.01.2018 0:48
 */
data class Post(
        @SerializedName("get_the_date") val getTheData: String?,
        @SerializedName("get_the_date_T") val getTheDataT: String?,
        @SerializedName("get_the_date_B") val getTheDataB: String?,
        val href: String?,
        val name: String?,
        val type: String?,
        val partnership: Boolean,
        val sponsorship: Boolean,
        val picture: String?,
        @SerializedName("picture_inner") val pictureInner: String?,
        @SerializedName("category_name") val categoryName: String?,
        @SerializedName("category_slug") val categorySlug: String?,
        val authoe0: String?,
        val authoe1: String?,
        val authoe2: String?,
        @SerializedName("text_color") val textColor: String?,
        @SerializedName("center_post") val centerPost: Boolean,
        @SerializedName("center_picture") val centerPicture: Boolean,
        val old: Boolean,
        @SerializedName("detail_announce") val detailAnnounce: String?
) {
    class Request(val paged: Int,
                  @SerializedName("posts_per_page") val postsPerPage: Int = 20,
                  val category: Int = 2
    )

    class Response {
        lateinit var posts: List<Post>;
    }
}
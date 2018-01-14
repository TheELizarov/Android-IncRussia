package ru.incrussia.app.model

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * Feed info
 *
 * Created by Sergey Elizarov elizarov1988@gmail.com
 *    on 14.01.2018 23:12
 */
class Feed(val posts: ArrayList<Post>) {
    class FeedDeserializer : JsonDeserializer<Feed> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Feed {
            val result = Feed(arrayListOf())
            result.posts.addAll(
                    Gson().fromJson<List<Post>>(
                            json,
                            object : TypeToken<List<Post>>() {}.type
                    )
            )
            return result
        }
    }
}
package ru.incrussia.app

import android.app.Application
import ru.incrussia.app.http.Api

/**
 * Created by Sergey Elizarov elizarov1988@gmail.com
 *    on 02.01.2018 0:38
 */
class App: Application() {
    companion object {
        lateinit var instance: App
        fun instance() = instance
    }

    lateinit var api: Api

    override fun onCreate() {
        super.onCreate()
        App.instance = this
        api = Api.build()
    }
}
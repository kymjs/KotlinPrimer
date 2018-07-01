package com.kymjs.project3.unit6

import com.kymjs.project3.unit4.User

/**
 * 音乐播放APP，每个用户都可以定制自己的播放器皮肤颜色
 */
class KotlinSDK private constructor() {
    companion object {
        fun get(): KotlinSDK {
            return Holder.instance
        }
    }

    private object Holder {
        val instance = KotlinSDK()
    }

    fun showPlayer(user: User) {
        MediaPlayerView(getPlayerView(user.playerType)).showView()
    }
}

package com.kymjs.project4.unit6

/**
 *
 * 当前以及支持的播放器皮肤有绿色和蓝色两种
 */
sealed class PlayerViewType {
    object GREEN : PlayerViewType()
    object BLUE : PlayerViewType()
    class VIP(val title: String? = null, val message: String? = null) : PlayerViewType()
}

fun getPlayerView(type: PlayerViewType) = when (type) {
    PlayerViewType.GREEN -> GreenPlayerView()
    PlayerViewType.BLUE -> BluePlayerView()
    is PlayerViewType.VIP -> VIPPlayer(type.title, type.message)
}


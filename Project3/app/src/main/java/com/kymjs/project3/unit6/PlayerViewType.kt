package com.kymjs.project3.unit6

/**
 *
 * 当前以及支持的播放器皮肤有绿色和蓝色两种
 */
sealed class PlayerViewType {
    object GREEN : PlayerViewType()
    object BLUE : PlayerViewType()
    object VIP : PlayerViewType(), PlayerView {
        override fun showView() {
            println("VIP视图")
        }

        override fun getPlayButton() {
        }
    }
}

fun getPlayerView(type: PlayerViewType) = when (type) {
    PlayerViewType.GREEN -> GreenPlayerView()
    PlayerViewType.BLUE -> BluePlayerView()
    is PlayerViewType.VIP -> PlayerViewType.VIP
}

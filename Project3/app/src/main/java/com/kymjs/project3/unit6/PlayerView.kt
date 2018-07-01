package com.kymjs.project3.unit6

/**
 * Created by ZhangTao on 18/6/14.
 */
interface PlayerView {
    fun showView()

    fun getPlayButton()
}

class GreenPlayerView : PlayerView {
    override fun getPlayButton() {
        println("显示绿色button")
    }

    override fun showView() {
        println("显示绿色播放器")
    }
}

class BluePlayerView : PlayerView {
    override fun getPlayButton() {
        println("显示蓝色button")
    }

    override fun showView() {
        println("显示蓝色播放器")
    }
}

class MediaPlayerView(playerView: PlayerView) : PlayerView by playerView

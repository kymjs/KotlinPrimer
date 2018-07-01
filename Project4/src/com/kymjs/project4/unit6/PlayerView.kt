package com.kymjs.project4.unit6

import javax.swing.JOptionPane

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
        JOptionPane.showConfirmDialog(null, "显示绿色播放器", "绿色播放器", JOptionPane.DEFAULT_OPTION)
    }
}

class MediaPlayerView(playerView: PlayerView) : PlayerView by playerView

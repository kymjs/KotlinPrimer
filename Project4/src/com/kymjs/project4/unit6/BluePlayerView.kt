package com.kymjs.project4.unit6

import javax.swing.JOptionPane

/**
 * Created by ZhangTao on 18/6/21.
 */
class BluePlayerView : PlayerView {

    override fun getPlayButton() {
        println("显示蓝色button")
    }

    override fun showView() {
        JOptionPane.showConfirmDialog(null, "显示蓝色播放器", "蓝色播放器", JOptionPane.DEFAULT_OPTION);
    }
}

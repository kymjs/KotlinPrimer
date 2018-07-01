package com.kymjs.project3.unit4

import com.kymjs.project3.unit6.PlayerViewType

/**
 * Created by ZhangTao on 18/6/13.
 */

data class User(var id: Int,
                var name: String,
                var playerType: PlayerViewType = PlayerViewType.VIP)

//class VIP(id: Int, name: String) : User(id, name)


package com.kymjs.project13.unit2

class ActivityManagerHook(var hook: IActivityManager) : IActivityManager by hook

interface IActivityManager {
    fun bindService()
    fun unbindService()
}
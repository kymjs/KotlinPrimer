package com.kymjs.mvpandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kymjs.mvpandroid.m.User
import com.kymjs.mvpandroid.p.IPresenter
import com.kymjs.mvpandroid.v.IView

class MainActivity : AppCompatActivity(), IView by MVPView() {

    inline fun <reified T : IPresenter> getPresenter(): T {
        return T::class.java.newInstance()
    }

//class MainActivity : AppCompatActivity(),
//        IView by MVPView(), IPresenter by EmptyPresenter() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())

        findViewById<Button>(R.id.button).setOnClickListener {
            getPresenter<EmptyPresenter>().doLogin()
//            doLogin()
        }
    }
}

class EmptyPresenter : IPresenter {
    override fun doLogin(): User {
        //执行各种逻辑
        return User(1, "zhangtao")
    }
}

class MVPView : IView {
    override fun getLayoutID() = R.layout.activity_main
}
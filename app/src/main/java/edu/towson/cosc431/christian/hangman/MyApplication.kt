package edu.towson.cosc431.christian.hangman

import android.app.Activity
import android.app.Application
import android.os.Bundle

class MyApplication : Application(), Application.ActivityLifecycleCallbacks {

    var isChoiceActivityVisable:Boolean = false
    var isChoiceAcivityStoped:Boolean = false

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityPaused(act: Activity?) {
        if(act is Choice) {
            isChoiceActivityVisable = false
        }
    }

    override fun onActivityResumed(act: Activity?) {
        if(act is Choice) {
            isChoiceActivityVisable = true
        }
    }

    override fun onActivityStarted(p0: Activity?) {
    }

    override fun onActivityDestroyed(p0: Activity?) {
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(act: Activity?) {

        if (act is Choice){
            isChoiceAcivityStoped = true
        }
    }

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
    }
}
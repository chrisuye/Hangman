package edu.towson.cosc431.christian.hangman

import android.app.Activity
import android.app.Application
import android.os.Bundle

class MyApplication : Application(), Application.ActivityLifecycleCallbacks {

    var isChoiceActivityVisable:Boolean = false
    var isChoiceAcivityStoped:Boolean = true

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityPaused(act: Activity?) {
        if(act is Choice) {
            isChoiceActivityVisable = false
        }
        if (act is Singleplayer){
            isChoiceAcivityStoped = true
        }
        if (act is Singlegame){
            isChoiceAcivityStoped = true
        }
        if (act is TwoPlayer){
            isChoiceAcivityStoped = true
        }
        if (act is TwoGame){
            isChoiceAcivityStoped = true
        }
        if (act is Score){
            isChoiceAcivityStoped = true
        }
        if (act is CustomInput){
            isChoiceAcivityStoped = true
        }
        if (act is CustomGame){
            isChoiceAcivityStoped = true
        }
    }

    override fun onActivityResumed(act: Activity?) {
        if(act is Choice) {
            isChoiceActivityVisable = true
        }
    }

    override fun onActivityStarted(act: Activity?) {
        if (act is Singleplayer){
            isChoiceAcivityStoped = false
        }
        if (act is Singlegame){
            isChoiceAcivityStoped = false
        }
        if (act is TwoPlayer){
            isChoiceAcivityStoped = false
        }
        if (act is TwoGame){
            isChoiceAcivityStoped = false
        }
        if (act is Score){
            isChoiceAcivityStoped = false
        }
        if (act is CustomInput){
            isChoiceAcivityStoped = false
        }
        if (act is CustomGame){
            isChoiceAcivityStoped = false
        }

    }

    override fun onActivityDestroyed(p0: Activity?) {
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(act: Activity?) {


    }

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {

    }
}
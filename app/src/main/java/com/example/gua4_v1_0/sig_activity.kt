package com.example.gua4_v1_0

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class sig_activity : AppCompatActivity() {
    private lateinit var timeButton:Button
    private lateinit var myCountDownTimer:MyCountDownTimer
    fun click_get(view: View){
        //设置Button点击事件触发倒计时
        myCountDownTimer.start()
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sig)

        timeButton = findViewById<Button>(R.id.get_check)
        myCountDownTimer = MyCountDownTimer(60000, 1000)




    }
    inner class MyCountDownTimer(millisInFuture: Long,countDownInterval: Long) :CountDownTimer(millisInFuture,countDownInterval){



        //计时过程
        override fun onTick(l: Long) {
            //防止计时过程中重复点击
            timeButton.setClickable(false)
            timeButton.setText((l / 1000).toString() + "秒")
        }
        //计时完毕的方法

        override fun onFinish() {
            //重新给Button设置文字

            timeButton.setText("重新获取");
            //设置可点击
            timeButton.setClickable(true);
        }
    }
}


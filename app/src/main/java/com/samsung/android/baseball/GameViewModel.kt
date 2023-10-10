package com.samsung.android.baseball

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val comNums = charArrayOf('1','2','3','4','5','6','7','8','9')
    private val _count = MutableLiveData(0)
    private val _logText = MutableLiveData("")
    val userNums = MutableLiveData("")

    val count: LiveData<Int>
        get() = _count
    val logText: LiveData<String>
        get() = _logText

    fun resetGame() {
        comNums.shuffle()
        _count.value = 0
        _logText.value = ""
        userNums.value = ""
    }

    fun getComNumbers(): String {
        return String(comNums).substring(0, 3)
    }

    fun checkNums(): Boolean {
        if (userNums.value!!.length != 3) return false

        var strike = 0
        var ball = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (userNums.value!!.get(i) == comNums[j]) {
                    if (i == j) ++strike
                    else ++ball
                }
            }
        }

        var newLog = "%s -> strike=%d, ball=%d\n".format(userNums.value, strike, ball)

        userNums.value = ""
        _count.value = _count.value!! + 1
        _logText.value = _logText.value + newLog

        if (strike == 3) return true
        return false
    }
}
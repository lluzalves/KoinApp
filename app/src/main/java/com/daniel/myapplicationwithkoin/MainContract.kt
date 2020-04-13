package com.daniel.myapplicationwithkoin

interface MainContract{

    interface MainView {
        fun onStartView()
        fun showData()
    }

    interface MainPresenter{
        val view : MainView
        fun getProfileName() : String
        fun onComplete()
    }

}
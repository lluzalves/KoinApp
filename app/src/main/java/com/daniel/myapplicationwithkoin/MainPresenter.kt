package com.daniel.myapplicationwithkoin

class MainPresenter constructor(override val view: MainContract.MainView) :
    MainContract.MainPresenter {

    override fun getProfileName(): String {
        return "student"
    }

    override fun onComplete() {
        view.showData()
    }

}
package com.daniel.myapplicationwithkoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.daniel.myapplicationwithkoin.preferences.AppPreferences
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private val mainPresenter: MainContract.MainPresenter by inject { parametersOf(this) }
    private val preferences: AppPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onStartView()
    }

    override fun onStartView() {
        val profileName = mainPresenter.getProfileName()
        preferences.saveProfileName(profileName)
        mainPresenter.onComplete()
    }

    override fun showData() {
        val storedName = preferences.getProfileName()
        Toast.makeText(this, storedName, Toast.LENGTH_LONG).show()
    }

}

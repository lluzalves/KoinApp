package com.daniel.myapplicationwithkoin

import com.daniel.myapplicationwithkoin.di.applicationModule
import com.nhaarman.mockito_kotlin.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest : KoinTest {

    private val view: MainContract.MainView = mock()
    private val presenter: MainContract.MainPresenter by inject { parametersOf(view) }

    @Before
    fun before() {
        startKoin {   modules(
            listOf(applicationModule)
        ) }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `check if the value returned by the presenter is student`() {
        val profileName = "student"
        assert(profileName == presenter.getProfileName())
    }
    @Test
    fun `check if presenter invokes view showData method`() {
       // presenter.onComplete()
        Mockito.verify(view).showData()
    }
}
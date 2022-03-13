package br.com.candeias.treino

import androidx.lifecycle.ViewModelProvider
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import util.singleton.FireStoreApi

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TreinoTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

  /*  @Test
    fun getTreinosInRemoteBAnk(){
        val mViewModel = ViewModelProvider.NewInstanceFactory()
            .create(TreinoViewModel::class.java)
        mViewModel.loadTreinosFromRemoteBank()
    }*/
/*
    @Test
    fun getTreinosTest(){
        val mViewModel = ViewModelProvider.NewInstanceFactory()
            .create(TreinoViewModel::class.java)
        var treinos= mutableListOf<Treino>()
        treinos= mViewModel?.getTreinos()!!
        treinos= mViewModel?.getTreinos()!!

    }*/

    @Test
    fun testeSigletonFireStoreApi(){
        Assert.assertEquals(FireStoreApi.firebaseFirestore,FireStoreApi.firebaseFirestore)

    }
}
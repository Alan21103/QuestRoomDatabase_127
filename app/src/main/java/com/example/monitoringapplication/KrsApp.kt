package com.example.monitoringapplication

import android.app.Application

import com.example.monitoringapplication.depedenciesinjection.ContainerApp


class KrsApp : Application(){
    // Fungsinya untuk menyimpan instance Container
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        // Membuat instance ContainerApp
        containerApp = ContainerApp(this)
        //Instance adalah object yang dibuat dari kelas
    }
}
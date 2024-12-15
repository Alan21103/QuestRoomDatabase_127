package com.example.monitoringapplication.depedenciesinjection

import android.content.Context
import com.example.monitoringapplication.data.database.KrsDatabase
import com.example.monitoringapplication.repository.LocalRepositoryMhs
import com.example.monitoringapplication.repository.RepositoryMhs

interface InterfaceContainerApp{
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp{
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}
package com.otsembo.buffoonapp

import android.app.Application
import androidx.work.* // ktlint-disable no-wildcard-imports
import com.otsembo.buffoonapp.workers.NameLogger
import java.util.concurrent.TimeUnit

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        oneTimeRequest()
        // periodicRequest()
    }

    private fun oneTimeRequest() {

        // constraints
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .build()

        val oneTimeLogger: WorkRequest = OneTimeWorkRequestBuilder<NameLogger>()
            .setInputData(
                workDataOf("NAME" to "Buffoon", "AGE" to 75)
            )
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(this).enqueue(oneTimeLogger)
    }

    private fun periodicRequest() {
        val periodicLogger: PeriodicWorkRequest = PeriodicWorkRequestBuilder<NameLogger>(
            10, TimeUnit.MILLISECONDS
        ).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "logger_worker_xyz", ExistingPeriodicWorkPolicy.KEEP, periodicLogger
        )
    }
}

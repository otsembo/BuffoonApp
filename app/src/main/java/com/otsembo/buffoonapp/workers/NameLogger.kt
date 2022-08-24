package com.otsembo.buffoonapp.workers

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class NameLogger(mCtx: Context, params: WorkerParameters) : Worker(mCtx, params) {
    override fun doWork(): Result {
        val name = inputData.getString("NAME")
        val age = inputData.getInt("AGE", 0)

        val name_and_age = "NAME: $name, AGE: $age"
        val output: Data = workDataOf("NAME_DATA" to name_and_age)

        // LOG DATA
        Log.d("WORKER_DATA", "I am working for $name_and_age")

        return Result.success(output)
    }
}

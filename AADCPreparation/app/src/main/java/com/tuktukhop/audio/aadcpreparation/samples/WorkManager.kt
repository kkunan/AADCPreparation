package com.tuktukhop.audio.aadcpreparation.samples

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams){
    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.

        //uploadImages()

        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }
}

fun runWorkOneTime(context: Context){
    val oneTimeWork = OneTimeWorkRequestBuilder<UploadWorker>().build()
    WorkManager.getInstance(context).enqueue(oneTimeWork)
}
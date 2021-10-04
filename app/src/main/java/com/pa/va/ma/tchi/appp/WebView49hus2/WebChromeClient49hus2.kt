package com.pa.va.ma.tchi.appp.WebView49hus2

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.pa.va.ma.tchi.appp.WebViewActivity49hus2
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class WebChromeClient49hus2(val activity49hus2: AppCompatActivity) : WebChromeClient() {

    override fun onShowFileChooser(
        webView49hus2: WebView?,
        filePathCallback49hus2: ValueCallback<Array<Uri>>?,
        fileChooserParams49hus2: FileChooserParams?
    ): Boolean {
        checkPermissions49hus2(activity49hus2)
        WebViewActivity49hus2.filepathCallback49hus2 = filePathCallback49hus2
        val captureIntent49hus2 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (captureIntent49hus2.resolveActivity(activity49hus2.packageManager) != null) {
            val providedFile49hus2 = createTempFile49hus2()
            WebViewActivity49hus2.uriView49hus2 = FileProvider.getUriForFile(
                activity49hus2,
                "${activity49hus2.applicationContext.packageName}.provider",
                providedFile49hus2
            )
            captureIntent49hus2.run {
                putExtra(MediaStore.EXTRA_OUTPUT, WebViewActivity49hus2.uriView49hus2)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            val actionIntent49hus2 = Intent(Intent.ACTION_GET_CONTENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "image/*"
            }
            val intentChooser49hus2 = Intent(Intent.ACTION_CHOOSER).apply {
                putExtra(Intent.EXTRA_INTENT, captureIntent49hus2)
                putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(actionIntent49hus2) )
            }
            activity49hus2.startActivityForResult(intentChooser49hus2, 0)
            return true

        }
        return super.onShowFileChooser(webView49hus2, filePathCallback49hus2, fileChooserParams49hus2)
    }

    private fun createTempFile49hus2 (): File  {
        val date49hus2 = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
            .format(Date())
        val fileDir4kwe2 = activity49hus2.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("TMP${date49hus2}_4kwe2", ".jpg", fileDir4kwe2)
    }

    private fun checkPermissions49hus2 (context49hus2: Context) {
        Dexter.withContext(context49hus2)
            .withPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(p0: MultiplePermissionsReport?) {
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: MutableList<PermissionRequest>?,
                    p1: PermissionToken?
                ) {

                }
            }).check()
    }
}
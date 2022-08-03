package com.sp.icon

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btnIcon1)
        val btn2 = findViewById<Button>(R.id.btnIcon2)
        val btn3 = findViewById<Button>(R.id.btnIcon3)

        btn1.setOnClickListener {
            changeIcon(
                LauncherAliasOne::class.java,
                LauncherAliasTwo::class.java,
                LauncherAliasThree::class.java
            )
        }

        btn2.setOnClickListener {
            changeIcon(
                LauncherAliasTwo::class.java,
                LauncherAliasOne::class.java,
                LauncherAliasThree::class.java
            )
        }

        btn3.setOnClickListener {
            changeIcon(
                LauncherAliasThree::class.java,
                LauncherAliasOne::class.java,
                LauncherAliasTwo::class.java
            )
        }
    }

    private fun changeIcon(
        enableClass: Class<*>,
        disableClass1: Class<*>,
        disableClass2: Class<*>
    ) {

        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@MainActivity,
                "com.sp.icon.MainActivity"
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )

        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@MainActivity,
                enableClass
            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@MainActivity,
                disableClass1
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@MainActivity,
                disableClass2
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
    }
}
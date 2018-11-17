package com.example.estudiante.testconexion

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ucb.bo.edu.testconexion.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSC.setOnClickListener {
            if(isConexion(it.context) ) {
                Toast.makeText(this, getString(R.string.txt_ccon), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.txt_scon), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isConexion( context: Context) : Boolean {
        var bConectado = false
        val ctx : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val redes = ctx.allNetworks
        var networkInfo: NetworkInfo
        redes.forEach {
            networkInfo = ctx.getNetworkInfo(it)

            if ( networkInfo.state == NetworkInfo.State.CONNECTED) {
                bConectado = true
            }
        }
        return bConectado
    }
}

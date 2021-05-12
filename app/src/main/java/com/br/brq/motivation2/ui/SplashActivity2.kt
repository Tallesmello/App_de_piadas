package com.br.brq.motivation2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.br.brq.motivation2.R
import com.br.brq.motivation2.infra.MotivationsConstants
import com.br.brq.motivation2.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash2.*

    private lateinit var mSecurityPreferences: SecurityPreferences

class SplashActivity2 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        salvarBtn.setOnClickListener(this)

        verifyName()

    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationsConstants.KEY.PERSON_NAME)
        if (name != "") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.salvarBtn) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = edirQualSeuNome.text.toString()

        if (name != "") {
            mSecurityPreferences.storeString(MotivationsConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

        } else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_LONG).show()
        }
    }
}
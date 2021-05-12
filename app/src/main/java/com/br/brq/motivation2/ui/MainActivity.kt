package com.br.brq.motivation2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.br.brq.motivation2.R
import com.br.brq.motivation2.infra.MotivationsConstants
import com.br.brq.motivation2.infra.SecurityPreferences
import com.br.brq.motivation2.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var filter: Int = MotivationsConstants.PHRASEFILTER.ALL
    private val mMock: Mock = Mock()

    // Inicialização tardia. Variável precisa do contexto para ser inicializada corretamente
    // Acesso ao SharedPreferences
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter: Int = MotivationsConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove Toolbar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // Inicializa variáveis
        mSecurityPreferences = SecurityPreferences(this)

        /** Busca o nome do usuário*/
        val name = mSecurityPreferences.getString(MotivationsConstants.KEY.PERSON_NAME)
        textName.text = "Olá, $name"


        //Lógica inicial de seleção
        imageAll.setColorFilter(resources.getColor(R.color.colorAccent))
        handleNewPhrase()

        buttonNewPhrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.imageAll, R.id.imageHappy, R.id.imageMorning)

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }


    /** Trata o filtro aplicado para as frases*/
    private fun handleFilter(id: Int) {

        imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.white))

        when (id) {
            R.id.imageAll -> {
                imageAll.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationsConstants.PHRASEFILTER.ALL
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationsConstants.PHRASEFILTER.HAPPY
            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter(resources.getColor(R.color.colorAccent))
                mPhraseFilter = MotivationsConstants.PHRASEFILTER.MORNING
            }
        }

    }

    /**Atualiza frase de motivação*/
    private fun handleNewPhrase() {
        textPrase.text = Mock().getPhrase(mPhraseFilter)
    }
}
package com.br.brq.motivation2.repository

import com.br.brq.motivation2.infra.MotivationsConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int)

fun Int.random(): Int {
    return java.util.Random().nextInt(this)
}

class Mock {

    private val ALL = MotivationsConstants.PHRASEFILTER.ALL
    private val HAPPY = MotivationsConstants.PHRASEFILTER.HAPPY
    private val MORNING = MotivationsConstants.PHRASEFILTER.HAPPY

    /** Mudar as piadas de dentro das categoria -> HAPPY - ALL - MORNING */

    private val mListPhrases: List<Phrase> = listOf(

        Phrase("O diretor da empresa pergunta ao novo funcionário:\n" +
            "\n" + "– O contador já lhe disse qual é sua tarefa?\n" +
            "\n" + "– Sim. Acordá-lo quando eu perceber que o senhor está vindo.",HAPPY),

        Phrase( "Na manhã de seu aniversário, uma mulher disse ao marido:\n" +
            "\n" + "- Sonhei que você me dava um colar de diamantes. O que acha que isso significa?\n" +
            "\n" + "- Talvez você descubra hoje à noite - respondeu ele.\n" +
            "\n" + "Naquela noite, o homem chegou em casa com um pequeno pacote e o entregou à mulher. Ela rasgou o papel de embrulho, ansiosa, e encontrou um livro: O significado dos sonhos.", HAPPY),

        Phrase("Porque o menino estava falando no telefone deitado?\n" +
                "\n" + "- Para não cair a ligação.",HAPPY),

        Phrase("A enfermeira diz ao médico: Tem um homem invisível na sala de espera.\n" +
                "\n" + "O médico responde: Diga a ele que não posso vê-lo agora.",HAPPY),

        Phrase("Qual é a fórmula da água benta?\n" +
                "\n" + "H Deus Ó.", HAPPY),

        Phrase("Qual a cidade brasileira que não tem táxi?\n" +
                "\n" + "Uberlândia.", HAPPY),

        Phrase("Porque o jacaré tirou o filho da escola?\n" +
                "\n" + "Porque ele réptil de ano.", MORNING),

        Phrase("Porque o Batman colocou o bat-móvel no seguro?\n" +
                "\n" + "Porque ele tem medo que Robin!",MORNING),

        Phrase("Qual é o alimento mais sagrado que existe?\n" +
                "\n" + "O amém doim.", MORNING),

        Phrase("Por que o policial não usa sabão?\n" +
                "\n" + "Porque ele prefere deter gente.", MORNING),
    )

    /**
     * Obtém frase aleatória de acordo com o filtro
     * */

    fun getPhrase(categoryId: Int): String {

        val filterred = mListPhrases.filter { (it.category == categoryId || categoryId == ALL) }

        val rand = java.util.Random().nextInt(filterred.size)
        return filterred[rand].description
    }
}
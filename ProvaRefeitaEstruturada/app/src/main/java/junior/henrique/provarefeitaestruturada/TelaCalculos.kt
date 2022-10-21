package junior.henrique.provarefeitaestruturada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_calculos.*
import kotlinx.android.synthetic.main.activity_tela_shape.*
import org.jetbrains.anko.toast

class TelaCalculos : AppCompatActivity() {

    var nome: String? = null
    var nota1: Double? = 0.0
    var nota2: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_calculos)

        button_calcular.setOnClickListener {
            if (editTextNome.text.toString().isNotEmpty() &&
                editTextNota1.text.toString().isNotEmpty() &&
                editTextNota2.text.toString().isNotEmpty()) {
                nome = editTextNome.text.toString()
                nota1 = editTextNota1.text.toString().toDouble()
                nota2 = editTextNota2.text.toString().toDouble()

                toast("Media: ${mediaAritimetica()}\n" + "Situação: ${Situação()}\n" +
                        "Conceito: ${Conceito()}"
                )
            }
        }

        buttonCalcularProbabilidade.setOnClickListener {
            textViewProbabilidade.text = Probabilidade().toString()
        }
    }

    fun mediaAritimetica(): Double? {
        return (nota1!! + nota2!!) / 2
    }

    fun Situação(): String {
        if (mediaAritimetica()!! >= 6) {
            return "Aprovado"
        }
        return "Reprovado"
    }

    fun Conceito(): String {
        if (mediaAritimetica()!! >= 9) {
            return "A"
        } else if(mediaAritimetica()!! >= 8 && mediaAritimetica()!! < 9) {
            return "B"
        } else if(mediaAritimetica()!! >= 6 && mediaAritimetica()!! < 8) {
            return "C"
        }
        return "D"
    }

    fun Probabilidade(): Int {
        return (0..100).random()
    }
}

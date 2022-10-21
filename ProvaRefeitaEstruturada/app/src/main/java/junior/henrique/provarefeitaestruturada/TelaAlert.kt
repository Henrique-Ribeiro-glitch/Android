package junior.henrique.provarefeitaestruturada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.alert

class TelaAlert : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_alert)

        alert ("Henrique e Leandro"){
            title = "Alert"
            positiveButton("Ok") {
            }
        }.show()
    }
}

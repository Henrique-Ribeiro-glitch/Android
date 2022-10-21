package junior.henrique.provarefeitaestruturada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoAsyncContext
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), AnkoLogger {

    lateinit var button_prova: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        button_prova.setOnClickListener {
            startActivity<HomeActivity>()
        }
    }

    fun initialize() {
        button_prova = findViewById(R.id.button_prova)
    }
}

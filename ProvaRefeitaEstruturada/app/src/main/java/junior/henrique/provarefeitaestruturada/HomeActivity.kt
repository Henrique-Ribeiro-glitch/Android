package junior.henrique.provarefeitaestruturada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity(), AnkoLogger {

    lateinit var buttonToast: Button
    lateinit var buttonAlert: Button
    lateinit var buttonShape: Button
    lateinit var buttonCalculos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initializeToast()

        buttonToast.setOnClickListener {
            startActivity<TelaToast>()
        }

        initializeAlert()

        buttonAlert.setOnClickListener {
            startActivity<TelaAlert>()
        }

        initializeSape()

        buttonShape.setOnClickListener {
            startActivity<TelaShape>()
        }

        initializeCalculos()

        buttonCalculos.setOnClickListener {
            startActivity<TelaCalculos>()
        }
    }

    fun initializeToast() {
        buttonToast = findViewById(R.id.button_toast)
    }

    fun initializeAlert() {
        buttonAlert = findViewById(R.id.button_alert)
    }

    fun initializeSape() {
        buttonShape = findViewById(R.id.button_shape)
    }

    fun initializeCalculos() {
        buttonCalculos = findViewById(R.id.button_calculos)
    }

}

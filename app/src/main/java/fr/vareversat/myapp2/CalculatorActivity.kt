package fr.vareversat.myapp2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*
import java.util.*
import kotlin.math.pow

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun addKey(view: View) {
        val key = view.tag.toString()
        edit_text_input.text = edit_text_input.text.toString() + key
    }

    fun binaryToDecimal(view: View) {
        val input = edit_text_input.text.toString()
        val binaryRegex = "([01]+)".toRegex()
        var result = 0.0
        if (binaryRegex.matches(input)) {
            for (i in input.length - 1 downTo 0) {
                val value = input[i].toString().toInt() * 2.0.pow((input.length - 1) - i)
                result += value
            }
            edit_text_input.text = result.toString()
        } else {
            edit_text_input.text = getString(R.string.error_string)
        }
    }

    fun recursiveFactorial(n: Double): Double {
        return if (n == 0.0) {
            1.0
        } else {
            return n * recursiveFactorial(n - 1)
        }
    }

    fun iterativeFactorial(n: Double): Double {
        var factorial = 1.0
        for (i in 1..n.toInt()) {
            factorial *= i
        }
        return factorial
    }

    fun recursivePower(n: Double, p: Int): Double {
        return if (p == 0) {
            1.0
        } else {
            return n * recursivePower(n, p - 1)
        }
    }

    fun iterativePower(n: Double, p: Int): Double {
        var power = 1.0
        if (p == 0) {
            return 1.0
        }
        for (i in 1..p) {
            power *= n
        }
        return power
    }

    fun decimalToBinary(view: View) {
        val input = edit_text_input.text.toString()
        val decimalRegex = "([0-9]+)".toRegex()
        if (decimalRegex.matches(input)) {
            var decNumber = input.toInt()
            var result = ""
            while (decNumber > 0) {
                val rem = decNumber % 2
                result += rem.toString()
                decNumber /= 2
            }
            edit_text_input.text = result.reversed()
        } else {
            edit_text_input.text = getString(R.string.error_string)
        }
    }

    fun clean(view: View) {
        edit_text_input.text = ""
    }

    fun computeCalculus(view: View) {
        val input = edit_text_input.text.toString()
        var result = 0.0
        var format = "%.1f"
        val calculusRegex = "([0-9]+\\.?[0-9]*)([x\\/\\-\\+\\^])([0-9]+\\.?[0-9]*)".toRegex()
        val factorialRegex = "([0-9]+\\.?[0-9]*)!".toRegex()
        if (calculusRegex.matches(input)) {
            val calculusResult = calculusRegex.find(input)
            val left = calculusResult!!.groupValues[1].toDouble()
            val right = calculusResult.groupValues[3].toDouble()
            result = when (calculusResult.groupValues[2]) {
                "+" -> left + right
                "-" -> left - right
                "x" -> left * right
                "/" -> left / right
                "^" -> recursivePower(left, right.toInt())
                else -> 0
            }.toDouble()
            format = "%.2f"
        } else if (factorialRegex.matches(input)) {
            val factorialResult = factorialRegex.find(input)
            val left = factorialResult!!.groupValues[1].toDouble()
            val factorial = recursiveFactorial(left)
            result = factorial
        }
        edit_text_input.text = String.format(Locale.US, format, result)
    }
}
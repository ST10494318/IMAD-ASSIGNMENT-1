package za.ac.iie.imad_task

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val time = findViewById<EditText>(R.id.time)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val output = findViewById<TextView>(R.id.output)

        submitButton.setOnClickListener {
            val dayTime = time.text.toString().trim().lowercase()
            val suggestion = getMealSuggestion(dayTime)

            if (suggestion != null) {
                output.text = "Meal: $suggestion"
            } else {
                Toast.makeText(this, "Invalid input. Please enter a valid time of day.", Toast.LENGTH_SHORT).show()
            }
        }

        resetButton.setOnClickListener {
            time.text.clear()
            output.text = ""
        }
    }

    private fun getMealSuggestion(dayTime: String): String? {
        return when (dayTime) {
            "morning" -> "Eggs"
            "mid-morning" -> "Fruit"
            "afternoon" -> "Sandwich"
            "mid-afternoon" -> "Cake"
            "dinner" -> "Pasta"
            "after dinner" -> "Ice cream"
            else -> null
        }
    }
}
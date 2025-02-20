import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


//state
class BmiViewModel : ViewModel() {
    private val _heightInput = MutableStateFlow("") // Incapsulation
    val heightInput = _heightInput.asStateFlow()

    private val _weightInput = MutableStateFlow("")
    val weightInput = _weightInput.asStateFlow()

    private val _bmiResult = MutableStateFlow("0.00")
    val bmiResult = _bmiResult.asStateFlow()

    //functions onChange
    fun onHeightChange(newValue: String) {
        _heightInput.value = newValue
        calculateBmi()
    }

    fun onWeightChange(newValue: String) {
        _weightInput.value = newValue
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = _heightInput.value.toFloatOrNull() ?: 0.0f
        val weight = _weightInput.value.toIntOrNull() ?: 0

        if (height > 0 && weight > 0) {
            val heightInMeters = height / 100
            val bmiValue = weight / (heightInMeters * heightInMeters)
            _bmiResult.value = String.format("%.2f", bmiValue)
        } else {
            _bmiResult.value = "0.00"
        }
    }
}

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learntogo_.R

@Composable
fun LocationScreen(navController: NavController) {

    /**Notwendige UI gestalten, sobald ein Button gedrückt wird
     * Daten-Abspeicherung in Firebase
     * */

    val noteValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    /** Add-Button für weitere Notizen, Felder stimmen noch nicht
     * ganz überein (Größe, etc.)
     */

    Box () {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = noteValue.value,
                onValueChange = { noteValue.value = it },
                label = { Text(text = "Name") },
                placeholder = { Text(text = "Name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),

                )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = { passwordValue.value = it },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    }
}



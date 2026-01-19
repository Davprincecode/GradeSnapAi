package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import designsystem.AppColors
import designsystem.Spacing
import ui.components.PrimaryButton

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Search


@Composable
fun InputAndScanBox() {
    var matric by remember { mutableStateOf("") }
    var scriptText by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Surface, RoundedCornerShape(Spacing.sm))
            .border(Spacing.xxxs, AppColors.PrimaryDark, shape = RoundedCornerShape(Spacing.sm))
            .padding(Spacing.md)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(Spacing.sm)) {

            // Matric Input with OCR & Camera
            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = matric,
                    onValueChange = { matric = it },
                    label = { Text("Matric Number") },
                    modifier = Modifier.weight(1f)
                )

                IconButton(onClick = {
                    // TODO: Open camera for matric capture
                }) {
                    Icon(Icons.Default.CameraAlt, contentDescription = "Camera")
                }
            }

            // Script Text with OCR & Camera
            Row(verticalAlignment = Alignment.CenterVertically) {
                OutlinedTextField(
                    value = scriptText,
                    onValueChange = { scriptText = it },
                    label = { Text("Script Text") },
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = {
                    // TODO: Open camera for script capture
                }) {
                    Icon(Icons.Default.CameraAlt, contentDescription = "Camera")
                }
            }

            // Score
            OutlinedTextField(
                value = score,
                onValueChange = { score = it },
                label = { Text("Score") },
                modifier = Modifier.fillMaxWidth()
            )

            PrimaryButton(
                text = "Submit",
                onClick = {
                    println("Button clicked!")
//                    navigator?.push(CreateCourse())
                }
            )


        }
    }
}

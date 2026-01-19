package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import designsystem.AppColors
import designsystem.Spacing

@Composable
fun GradesTableBox() {
    val dummyData = listOf(
        "MAT001" to 78,
        "MAT002" to 65,
        "MAT003" to 90,
        "MAT004" to 55,
        "MAT005" to 88,
        "MAT006" to 72,
        "MAT007" to 61,
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.Surface, RoundedCornerShape(Spacing.sm))
            .border(Spacing.xxxs, AppColors.PrimaryDark, shape = RoundedCornerShape(Spacing.sm))
            .padding(Spacing.md)
    ) {
        LazyColumn {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Matric No", fontWeight = FontWeight.Bold)
                    Text("Score", fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(Spacing.lg))
            }

            items(dummyData) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(item.first)
                    Text(item.second.toString())
                }
                Divider()
            }
        }
    }
}

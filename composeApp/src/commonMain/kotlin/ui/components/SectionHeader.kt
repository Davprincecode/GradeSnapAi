package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.AppColors
import designsystem.AppTypography

@Composable
fun SectionHeader(
    title: String,
) {
    Text(title, style = AppTypography.default.headlineMedium, color = AppColors.TextPrimary)
}

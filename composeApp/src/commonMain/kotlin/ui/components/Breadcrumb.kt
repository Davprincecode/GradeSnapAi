package ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import designsystem.AppColors
import designsystem.AppTypography

@Composable
fun Breadcrumb(

    items: List<String>,
    modifier: Modifier = Modifier,
    separator: String = " > "
) {
    Row(modifier = modifier) {
        Text(
            text = items.joinToString(separator),
            style = AppTypography.default.bodyMedium,
            color = AppColors.TextSecondary
        )
    }
}

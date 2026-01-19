package ui

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import designsystem.AppTheme
import ui.screens.Courses

@Composable
fun AppRoot(darkTheme: Boolean) {
    AppTheme(darkTheme = darkTheme) {
        Navigator(Courses())
    }
}

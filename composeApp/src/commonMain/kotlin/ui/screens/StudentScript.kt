   package ui.screens

    import androidx.compose.runtime.Composable
    import cafe.adriel.voyager.core.screen.Screen
    import cafe.adriel.voyager.navigator.LocalNavigator

    class StudentScript  : Screen {
        @Composable
        override fun Content() {
            val navigator = LocalNavigator.current
        }
    }
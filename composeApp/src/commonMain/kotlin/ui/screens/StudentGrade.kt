package ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import designsystem.Spacing
import navigation.Route
import ui.components.SectionHeader

class StudentGrade : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing.md),
               verticalArrangement = Arrangement.spacedBy(Spacing.sm)
        ) {

            Spacer(Modifier.height(Spacing.lg))

            SectionHeader(title = Route.StudentGrade.title)

            GradesTableBox()
            InputAndScanBox()
        }
    }
}

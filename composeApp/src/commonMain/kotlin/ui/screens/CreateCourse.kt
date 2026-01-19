package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import designsystem.AppColors
import designsystem.AppTypography
import designsystem.Spacing
import navigation.Route
import ui.components.Breadcrumb
import ui.components.PrimaryButton

class CreateCourse : Screen {
    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing.md)
        ) {
//            Breadcrumb(
//                items = listOf(
//                    Route.Dashboard.title,
//                    Route.Courses.title,
//                    Route.CreateCourse.title
//                )
//            )

            Spacer(Modifier.height(Spacing.lg))

            Text(Route.CreateCourse.title, style = AppTypography.default.headlineMedium)

            Spacer(Modifier.height(Spacing.md))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColors.Surface, RoundedCornerShape(Spacing.sm))
                    .border(Spacing.xxxs, AppColors.PrimaryDark, shape = RoundedCornerShape(Spacing.sm))
                    .padding(Spacing.md)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Spacing.sm)
                ) {

                    // State holders for input
                    var courseCode by remember { mutableStateOf("") }
                    var courseName by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = courseCode,
                        onValueChange = { courseCode = it },
                        label = { Text("Course Code") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(Spacing.md))

                    OutlinedTextField(
                        value = courseName,
                        onValueChange = { courseName = it },
                        label = { Text("Course Name") },
                        modifier = Modifier.fillMaxWidth() )

                    Spacer(Modifier.height(Spacing.lg))

                    PrimaryButton( text = "Submit",
                        onClick = { println("Submitted: $courseCode - $courseName")
                                  },
                        modifier = Modifier.fillMaxWidth()
                    )

                }}




        }
    }
}
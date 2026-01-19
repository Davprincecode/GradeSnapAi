package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import designsystem.Spacing
import designsystem.AppColors
import designsystem.AppTypography
import model.Course
import navigation.Route
import ui.components.Breadcrumb
import ui.components.PrimaryButton
import ui.components.SectionHeader

class Courses : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val dummyCourses = listOf(
            Course("MATH101", "Mathematics", 45),
            Course("PHY201", "Physics", 30),
            Course("CS301", "Computer Science", 60),
            Course("CS402", "Introduction To Ai", 60),
            Course("CS405", "Computing", 60),
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing.md)
                .verticalScroll(rememberScrollState())
        ) {
            Breadcrumb(items = listOf(Route.Dashboard.title, Route.Courses.title))

            Spacer(Modifier.height(Spacing.sm))

            SectionHeader(title = Route.Courses.title)

            Text("test — yaba.pdf")
            Text("Hello world dear")

            Spacer(Modifier.height(Spacing.md))

            PrimaryButton(
                text = "+ Create New Assignment",
                onClick = {
                    println("Button clicked!")
                    navigator?.push(CreateCourse())
                }
            )

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
                    dummyCourses.forEach { course ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(Spacing.md)
                                .background(AppColors.Surface, RoundedCornerShape(Spacing.sm))
                                .border(Spacing.xxxs, AppColors.BorderColor, shape = RoundedCornerShape(Spacing.sm))
                                .padding(Spacing.lg)
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = course.courseName.replaceFirstChar { it.uppercaseChar() },
                                    style = AppTypography.default.headlineMedium
                                )
                                Text(
                                    text = course.courseId,
                                    style = AppTypography.default.bodyMedium
                                )
                                Text(
                                    text = "Graded: ${course.noOfStudentGraded}",
                                    style = AppTypography.default.bodyMedium
                                )

                                PrimaryButton(
                                    text = "View",
                                    onClick = { navigator?.push(StudentGrade()) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}



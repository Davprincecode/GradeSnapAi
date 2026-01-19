package ui.components

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import navigation.Route
import ui.screens.Courses
import ui.screens.CreateCourse


@Composable
fun AutoBreadcrumb() {
    val navigator = LocalNavigator.current
    val titles = buildList {
        add(Route.Dashboard.title)
        navigator?.items?.forEach { screen ->
            when (screen) {
                is Courses -> add(Route.Courses.title)
                is CreateCourse -> add(Route.CreateCourse.title)
            }
        }
    }
    Breadcrumb(items = titles)
}

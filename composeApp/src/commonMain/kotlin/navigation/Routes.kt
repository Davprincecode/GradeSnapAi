package navigation

sealed class Route(val title: String) {
    data object Dashboard : Route("Dashboard")

    data object Courses : Route("Courses Graded")
    data object CreateCourse : Route("Create New Course")
    data class AssignmentDetail(val id: String) : Route("Assignment Detail")
}

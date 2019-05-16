package et.edu.aait.roomdbexample.repository

import androidx.lifecycle.LiveData
import et.edu.aait.roomdbexample.data.Course
import et.edu.aait.roomdbexample.data.CourseDao

class CourseRepository(private val courseDao: CourseDao) {

    fun allCourses(): LiveData<List<Course>> = courseDao.getAllCourses()

    fun insertCourse(course: Course) {
        courseDao.insertCourse(course)
    }
}



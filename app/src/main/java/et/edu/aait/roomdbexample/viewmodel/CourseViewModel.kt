package et.edu.aait.roomdbexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import et.edu.aait.roomdbexample.data.Course
import et.edu.aait.roomdbexample.data.CourseDatabase
import et.edu.aait.roomdbexample.repository.CourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel(application: Application): AndroidViewModel(application) {

    private val courseRepository: CourseRepository
    val allCourses: LiveData<List<Course>>

    init {
        val courseDao = CourseDatabase.getDatabase(application).courseDao()
        courseRepository = CourseRepository(courseDao)
        allCourses = courseRepository.allCourses()
    }

    fun insertCourse(course: Course) = viewModelScope.launch(Dispatchers.IO) {
        courseRepository.insertCourse(course)
    }
}



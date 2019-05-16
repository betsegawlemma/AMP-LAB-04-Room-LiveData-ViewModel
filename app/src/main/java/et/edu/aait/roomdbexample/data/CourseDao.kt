package et.edu.aait.roomdbexample.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CourseDao {

    @Query("SELECT * from courses ORDER BY course_code")
    fun getAllCourses(): LiveData<List<Course>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course):Long
}


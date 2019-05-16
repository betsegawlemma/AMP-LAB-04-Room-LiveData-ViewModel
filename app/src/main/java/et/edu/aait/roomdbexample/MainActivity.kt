package et.edu.aait.roomdbexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import et.edu.aait.roomdbexample.data.Course
import et.edu.aait.roomdbexample.viewmodel.CourseViewModel
import kotlinx.android.synthetic.main.activity_main.*

const val NEW_COURSE_ACTIVITY_REQUEST_CODE = 1

class MainActivity : AppCompatActivity(){

    lateinit var courseViewModel: CourseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val courseListAdapter = CourseListAdapter(this)
        recycler_view.adapter = courseListAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            val intent = Intent(this, NewCourseActivity::class.java)
            startActivityForResult(intent, NEW_COURSE_ACTIVITY_REQUEST_CODE)
        }

        courseViewModel = ViewModelProviders.of(this).get(CourseViewModel::class.java)

        courseViewModel.allCourses.observe(this, Observer {
           courses -> courses?.let{ courseListAdapter.setCourses(courses)}
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == NEW_COURSE_ACTIVITY_REQUEST_CODE &&
            resultCode == Activity.RESULT_OK){
                val course:Course = data?.getSerializableExtra("COURSE") as Course
                    courseViewModel.insertCourse(course)
        }
    }
}


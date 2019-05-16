package et.edu.aait.roomdbexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import et.edu.aait.roomdbexample.data.Course
import kotlinx.android.synthetic.main.activity_new_course.*

class NewCourseActivity : AppCompatActivity() {

    private lateinit var addButton: Button

    private lateinit var titleEditText: EditText
    private lateinit var codeEditText: EditText
    private lateinit var ectsEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_course)

        addButton = add_button

        titleEditText = title_edit_text
        codeEditText = code_edit_text
        descriptionEditText = description_edit_text
        ectsEditText = ects_edit_text

        addButton.setOnClickListener {
            val course = readFields()
            val replyCourseIntent = Intent()
            replyCourseIntent.putExtra("COURSE", course)
            setResult(Activity.RESULT_OK, replyCourseIntent)
            finish()
        }
    }

    private fun readFields() = Course(
            codeEditText.text.toString(),
            titleEditText.text.toString(),
            ectsEditText.text.toString().toInt(),
            descriptionEditText.text.toString()
        )
}

package et.edu.aait.roomdbexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import et.edu.aait.roomdbexample.data.Course
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CourseListAdapter(context: Context):
   RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>() {

   private val inflater = LayoutInflater.from(context)
   private var courses: List<Course> = emptyList()

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {

      val recyclerViewItem =
         inflater
            .inflate(R.layout.recycler_view_item, parent, false)

      return CourseViewHolder(recyclerViewItem)
   }

   override fun getItemCount() = courses.size

   override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
      val course = courses[position]
      holder.codeTextView.text = course.code
      holder.titleTextView.text = course.title
   }

   internal fun setCourses(courses: List<Course>){
      this.courses = courses
      notifyDataSetChanged()
   }

   inner class CourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      val codeTextView = itemView.list_code_textview
      val titleTextView = itemView.list_title_textview
   }
}



package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Data class to hold all information for a single student.
 * This ensures that the name, description, and image are always linked together.
 */
data class Student(
    val name: String,
    val description: String,
    val imageResId: Int
)

class MainActivity : AppCompatActivity() {

    // A list to hold all our student objects.
    private val studentList = listOf(
        Student(
            name = "Student 1",
            description = "My name is Jhoram. I like to watch movies and listen to music. I like to play single player and multiplayer games.",
            imageResId = R.drawable.student1 // Replace with your actual image
        ),
        Student(
            name = "Student 2",
            description = "My name is Jep and I love to play video games and DIY to everything.",
            imageResId = R.drawable.student2 // Replace with your actual image
        ),
        Student(
            name = "Student 3",
            description = "Hello My Name is Jillian! One thing about me is I love orange cats \uD83D\uDC08 " ,
            imageResId = R.drawable.student3 // Replace with your actual image
        ),
        Student(
            name = "Student 4",
            description = "My name is Ram. Im hungry",
            imageResId = R.drawable.student4 // Replace with your actual image
        ),
        Student(
            name = "Student 5",
            description = "Hi! My Name is Clarice! I love matcha and dogs",
            imageResId = R.drawable.student5 // Replace with your actual image
        )
    )

    // A variable to keep track of the currently displayed student.
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the views from our layout.
        val switchButton: Button = findViewById(R.id.switch_button)
        val profileImage: ImageView = findViewById(R.id.profile_image)
        val nameText: TextView = findViewById(R.id.name_text)
        val aboutMeText: TextView = findViewById(R.id.about_me_text)

        // Set the initial profile to the first student in the list.
        updateProfile(profileImage, nameText, aboutMeText)

        // Set a click listener on the button.
        switchButton.setOnClickListener {
            // Move to the next student in the list.
            currentIndex++

            // If we've gone past the end of the list, loop back to the beginning.
            if (currentIndex >= studentList.size) {
                currentIndex = 0
            }

            // Update the UI with the new student's information.
            updateProfile(profileImage, nameText, aboutMeText)
        }
    }

    /**
     * A helper function to update the UI elements with the current student's data.
     */
    private fun updateProfile(profileImage: ImageView, nameText: TextView, aboutMeText: TextView) {
        // Get the student object at the current index.
        val currentStudent = studentList[currentIndex]

        // Set the image and text views with the data from the student object.
        profileImage.setImageResource(currentStudent.imageResId)
        nameText.text = currentStudent.name
        aboutMeText.text = currentStudent.description
    }
}

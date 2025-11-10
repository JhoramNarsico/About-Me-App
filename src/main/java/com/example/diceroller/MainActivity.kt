package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

data class Student(
    val name: String,
    val description: String,
    val imageResId: Int
)

class MainActivity : AppCompatActivity() {


    private val studentList = listOf(
        Student(
            name = "Student 1",
            description = "I like to watch movies and listen to music. I like to play single player and multiplayer games.",
            imageResId = R.drawable.student1 // Replace with your actual image
        ),
        Student(
            name = "Student 2",
            description = "This is the detailed description for Student 2. Their focus is on UI/UX design and creative arts.",
            imageResId = R.drawable.student2 // Replace with your actual image
        ),
        Student(
            name = "Student 3",
            description = "This is the detailed description for Student 3. They are passionate about backend systems and databases.",
            imageResId = R.drawable.student3 // Replace with your actual image
        ),
        Student(
            name = "Student 4",
            description = "This is the detailed description for Student 4. They specialize in cybersecurity and network infrastructure.",
            imageResId = R.drawable.student4 // Replace with your actual image
        ),
        Student(
            name = "Student 5",
            description = "This is the detailed description for Student 5. Their main interest is in data science and machine learning.",
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

    private fun updateProfile(profileImage: ImageView, nameText: TextView, aboutMeText: TextView) {
        // Get the student object at the current index.
        val currentStudent = studentList[currentIndex]

        // Set the image and text views with the data from the student object.
        profileImage.setImageResource(currentStudent.imageResId)
        nameText.text = currentStudent.name
        aboutMeText.text = currentStudent.description
    }
}

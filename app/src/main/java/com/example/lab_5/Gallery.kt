package com.example.lab_5

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Gallery : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var nameInput: EditText
    private lateinit var ageInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var usernameInput: EditText // Added username field

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        emailInput = findViewById(R.id.email)
        nameInput = findViewById(R.id.fullname)
        ageInput = findViewById(R.id.age)
        phoneInput = findViewById(R.id.phone)
        passwordInput = findViewById(R.id.password)
        confirmPasswordInput = findViewById(R.id.confirmpassword)
        usernameInput = findViewById(R.id.username) // Initialize username field
    }

    override fun onResume() {
        super.onResume()
        // Fetching the stored data from the SharedPreferences
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val name = sharedPreferences.getString("name", "")
        val age = sharedPreferences.getInt("age", 0)
        val phone = sharedPreferences.getString("phone", "")
        val password = sharedPreferences.getString("password", "")
        val confirmPassword = sharedPreferences.getString("confirm_password", "")
        val username = sharedPreferences.getString("username", "") // Retrieve username

        // Setting the fetched data in the EditTexts
        emailInput.setText(email)
        nameInput.setText(name)
        ageInput.setText(age.toString())
        phoneInput.setText(phone)
        passwordInput.setText(password)
        confirmPasswordInput.setText(confirmPassword)
        usernameInput.setText(username) // Set username
    }

    override fun onPause() {
        super.onPause()
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreferences and apply
        editor.putString("email", emailInput.text.toString())
        editor.putString("name", nameInput.text.toString())
        editor.putInt("age", ageInput.text.toString().toInt())
        editor.putString("phone", phoneInput.text.toString())
        editor.putString("password", passwordInput.text.toString())
        editor.putString("confirm_password", confirmPasswordInput.text.toString())
        editor.putString("username", usernameInput.text.toString()) // Store username
        editor.apply()
    }
}

package com.example.baatuni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.baatuni.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
//        signup_username = findViewById(R.id.Signup_username)
//        signin_button = findViewById(R.id.SignIn_button)
//        signup_login_text = findViewById(R.id.Signup_login_text)

        binding.SignInButton.setOnClickListener {
            val email = binding.SignupEmail.editableText.toString()
            val password = binding.SignupPassword.editableText.toString()
            signUp(email, password)
        }
    }

    private fun signUp(email: String, password: String) {
        //logic for login in User
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this@SignUp) { task ->
                if (task.isSuccessful) {
                    // if task is successful then we have to jump to the home activity
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
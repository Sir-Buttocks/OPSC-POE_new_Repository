package gamers.code.digitalcupboard

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {
    private var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)
        auth = FirebaseAuth.getInstance();
        val signin = findViewById<Button>(R.id.login)
        val mEmail = findViewById<EditText>(R.id.username)
        val mPassword = findViewById<EditText>(R.id.password)


        signin.setOnClickListener {
            createAccount(mEmail.text.toString(), mPassword.text.toString())
        }
    }

    private fun createAccount(email: String, password: String) {
        auth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth!!.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }
}
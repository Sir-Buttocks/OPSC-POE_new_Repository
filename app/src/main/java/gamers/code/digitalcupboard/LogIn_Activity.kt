package gamers.code.digitalcupboard

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import gamers.code.digitalcupboard.ui.dashboard.DashboardFragment
import kotlinx.coroutines.MainScope

class LogIn_Activity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        auth = FirebaseAuth.getInstance();
        val signin = findViewById<Button>(R.id.login)
        val mEmail = findViewById<EditText>(R.id.username)
        val mPassword = findViewById<EditText>(R.id.password)


        signin.setOnClickListener {
            LogIn(mEmail.text.toString(), mPassword.text.toString())
        }

    }
    fun LogIn(email: String,password:String){
        auth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val navController = findNavController(R.id.nav_host_fragment_activity_main)
                   // MainActivity::class.java(R.id.nav_host_fragment_activity_main).findNavController().navigate(R.id.action_loginFragment_to_navigation_dashboard)



                    val user = auth!!.currentUser

                   ///navigate form LogIn_Activity to Fragment

                   // val intent = Intent(this, MainActivity::class.java)
                   // startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }

}

private fun Unit.findNavController() {

}

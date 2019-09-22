package cc.captaincode.hurrileaf.activities.sponsors.viewModel


import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorRegistration
import cc.captaincode.hurrileaf.coordinators.SponsorCoordinator
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sponsor_login_registration.*


private var mAuth: FirebaseAuth? = null
class SponsorLoginViewModel(private val sponsorLoginRegistration: SponsorRegistration) {

    fun login(username: String, password: String) {
        mAuth = FirebaseAuth.getInstance()

        FirebaseApp.initializeApp(sponsorLoginRegistration)

        FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
            .addOnCompleteListener()
            {
                if(it.isSuccessful)
                {
                    SponsorCoordinator(sponsorLoginRegistration)
                }
                else
                {
                    Toast.makeText(
                        sponsorLoginRegistration, "Error: " + it.exception?.message,
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }.addOnFailureListener{
                Toast.makeText(
                    sponsorLoginRegistration, "Error: ${it.message}", Toast.LENGTH_LONG
                ).show()
            }


    }
}
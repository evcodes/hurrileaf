package cc.captaincode.hurrileaf.activities.sponsors.viewModel


import android.widget.Toast
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorLoginRegistration
import cc.captaincode.hurrileaf.coordinators.SponsorCoordinator
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

private var mAuth: FirebaseAuth? = null
class SponsorLoginViewModel(private val sponsorLoginRegistration: SponsorLoginRegistration) {

    fun login(username: String, password: String) {
        mAuth = FirebaseAuth.getInstance()

        FirebaseApp.initializeApp(sponsorLoginRegistration)

        FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
            .addOnCompleteListener()
            {
                if(it.isSuccessful)
                {
                    SponsorCoordinator(sponsorLoginRegistration).loginSponsor()
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
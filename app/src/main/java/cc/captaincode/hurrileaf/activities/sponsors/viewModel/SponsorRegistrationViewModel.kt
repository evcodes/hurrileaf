package cc.captaincode.hurrileaf.activities.sponsors.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorLoginRegistration
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorRegistration
import cc.captaincode.hurrileaf.data.Sponsor
import com.google.firebase.auth.FirebaseAuth

class SponsorRegistrationViewModel(private val sponsorRegistration: SponsorRegistration) : ViewModel() {

    fun saveSponsor(sponsor: Sponsor){

    }
    fun registerUser(sponsor: Sponsor) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            sponsor.email, sponsor.password
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("hello", "we're here")
                saveSponsor(sponsor)
                Toast.makeText(
                    sponsorRegistration, "Register success",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    sponsorRegistration, "Error:" +
                            it.exception?.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }.addOnFailureListener {
            Toast.makeText(
                sponsorRegistration,
                "Error: ${it.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
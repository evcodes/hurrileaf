package cc.captaincode.hurrileaf.activities.sponsors.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.sponsors.viewModel.SponsorRegistrationViewModel
import cc.captaincode.hurrileaf.coordinators.SponsorCoordinator
import cc.captaincode.hurrileaf.data.Sponsor
import kotlinx.android.synthetic.main.sponsor_terms.*

class TermsOfServiceActivity() :
    AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sponsor_terms)

        btnAgreeTerms.setOnClickListener {
            returnToDash()
        }

    }
    fun returnToDash (){
        finish()
        finish()
    }

}
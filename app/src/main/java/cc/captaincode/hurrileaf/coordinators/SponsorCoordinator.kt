package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorDashboardActivity
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorRegistration
import cc.captaincode.hurrileaf.activities.sponsors.ui.TermsOfServiceActivity
import cc.captaincode.hurrileaf.data.Sponsor

class SponsorCoordinator(private val context: Context){


    fun startRegistrationActivity(){
        context.startActivity(Intent(context, SponsorRegistration::class.java))
    }
    fun loginSponsor(){
        context.startActivity(Intent(context, SponsorDashboardActivity::class.java))
    }

    fun startTermsOfService(){
        context.startActivity(Intent(context, TermsOfServiceActivity::class.java))
    }
}
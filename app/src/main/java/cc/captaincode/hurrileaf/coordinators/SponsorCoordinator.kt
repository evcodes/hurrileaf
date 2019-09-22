package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorDashboardActivity
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorRegistration

class SponsorCoordinator(private val context: Context){

    companion object {
        fun init(context: Context) {
            sponsorCoordinator =
                SponsorCoordinator(context)
        }

        var sponsorCoordinator: SponsorCoordinator? = null
    }

    fun startRegistrationActivity(){
        context.startActivity(Intent(context, SponsorRegistration::class.java))
    }
    fun loginSponsor(){
        context.startActivity(Intent(context, SponsorDashboardActivity::class.java))
    }
}
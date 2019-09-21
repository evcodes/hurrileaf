package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.donations.ui.DonationTypeActivity
import cc.captaincode.hurrileaf.activities.goodsDonation.ui.GoodsDonationActivity
import cc.captaincode.hurrileaf.activities.paymentDonation.ui.PaymentDonationActivity
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorFormActivity
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorLoginRegistration

class HomeCoordinator (context: Context){

    companion object {
        fun init(context: Context) {
            mainCoordinator =
                HomeCoordinator(context)
        }

        var mainCoordinator: HomeCoordinator? = null
    }

    fun startDonationSelectionActivity(context: Context){
        context.startActivity(Intent(context, DonationTypeActivity::class.java))
    }
    fun startSponsorInitActivity(context: Context){
        context.startActivity(Intent(context, SponsorLoginRegistration::class.java))
    }
    fun paymentInformationActivity(context: Context){
        context.startActivity(Intent(context, PaymentDonationActivity::class.java))
    }
    fun goodsDonationActivty(context: Context){
        context.startActivity(Intent(context, GoodsDonationActivity::class.java))
    }
}
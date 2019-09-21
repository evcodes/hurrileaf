package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.donations.ui.CashDonationActivity

class DonationCoordinator (context: Context){

    companion object {
        fun init(context: Context) {
            donationCoordinator =
                DonationCoordinator(context)
        }

        var donationCoordinator: DonationCoordinator? = null
    }

    fun startCashDonation(context: Context){
        context.startActivity(Intent(context, CashDonationActivity::class.java))
    }

}
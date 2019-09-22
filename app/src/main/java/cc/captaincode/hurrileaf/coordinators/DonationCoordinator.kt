package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.donations.ui.CashDonationActivity
import cc.captaincode.hurrileaf.activities.goodsDonation.ui.DonationMapping

class DonationCoordinator (private val context: Context){

    companion object {
        fun init(context: Context) {
            donationCoordinator =
                DonationCoordinator(context)
        }

        var donationCoordinator: DonationCoordinator? = null
    }

    fun startCashDonation(){
        context.startActivity(Intent(context, CashDonationActivity::class.java))
    }

    fun startGoodsDonation(){
        context.startActivity(Intent(context, DonationMapping::class.java))
    }

}
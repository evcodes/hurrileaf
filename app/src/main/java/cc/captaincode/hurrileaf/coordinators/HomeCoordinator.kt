package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.donations.ui.DonationTypeActivity
import cc.captaincode.hurrileaf.activities.goodsDonation.ui.GoodsDonationActivity
import cc.captaincode.hurrileaf.activities.paymentDonation.ui.PaymentDonationActivity
import cc.captaincode.hurrileaf.activities.sponsors.ui.SponsorFormActivity

class HomeCoordinator (context: Context){

    fun startDonationSelectionActivity(context: Context){
        context.startActivity(Intent(context, DonationTypeActivity::class.java))
    }fun startSponsorInfoActivity(context: Context){
        context.startActivity(Intent(context, SponsorFormActivity::class.java))
    }
    fun paymentInformationActivity(context: Context){
        context.startActivity(Intent(context, PaymentDonationActivity::class.java))
    }
    fun goodsDonationActivty(context: Context){
        context.startActivity(Intent(context, GoodsDonationActivity::class.java))
    }
}
package cc.captaincode.hurrileaf.coordinators

import android.content.Context
import android.content.Intent
import cc.captaincode.hurrileaf.activities.paymentDonation.ui.PaymentDonationActivity


class CashDonationCoordinator(val context: Context){

    companion object{
        fun init(context:Context){

        }

    }
    fun startCashDonation(resource:String){
        var paymentInfoExtras = Intent(context, PaymentDonationActivity::class.java ).putExtra("resourceCategory", resource)
        context.startActivity(paymentInfoExtras)
    }
}
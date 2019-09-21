package cc.captaincode.hurrileaf.coordinators

import android.content.Context

class DonationCoordinator (context: Context){

    companion object {
        fun init(context: Context) {
            donationCoordinator =
                DonationCoordinator(context)
        }

        var donationCoordinator: DonationCoordinator? = null
    }
}
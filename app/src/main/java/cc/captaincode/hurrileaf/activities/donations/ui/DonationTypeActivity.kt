package cc.captaincode.hurrileaf.activities.donations.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.captaincode.hurrileaf.coordinators.DonationCoordinator
import kotlinx.android.synthetic.main.activity_donation_type.*

import android.content.Context
import cc.captaincode.hurrileaf.R


class DonationTypeActivity : AppCompatActivity() {

    var donationCoordinator = DonationCoordinator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation_type)

        tvCashLabel.setOnClickListener { startCashDonation() }
        tvGoodsLabel.setOnClickListener { startGoodsDonation() }
    }

    private fun startCashDonation(){
        donationCoordinator.startCashDonation()
    }

    private fun startGoodsDonation(){
        donationCoordinator.startGoodsDonation()
    }

}

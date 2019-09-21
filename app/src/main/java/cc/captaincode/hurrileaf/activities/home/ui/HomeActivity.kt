package cc.captaincode.hurrileaf.activities.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.coordinators.HomeCoordinator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    val coordinator = HomeCoordinator(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        btnDonate.setOnClickListener { startDonation() }
        btnSponsor.setOnClickListener { startSponsor() }
    }

    private fun startDonation(){
        coordinator.startDonationSelectionActivity(this)
    }
    private fun startSponsor(){
        coordinator.startSponsorInitActivity(this)
    }


}

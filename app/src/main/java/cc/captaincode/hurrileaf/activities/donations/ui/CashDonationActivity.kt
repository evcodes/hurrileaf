package cc.captaincode.hurrileaf.activities.donations.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import cc.captaincode.hurrileaf.R
import cc.captaincode.hurrileaf.activities.paymentDonation.ui.PaymentDonationActivity
import kotlinx.android.synthetic.main.activity_cash_donation.*

// construction
// clothes
// water
// medicine
class CashDonationActivity : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_donation)
        //Context context = this
        waterButton.setOnClickListener{waterButtonDonation()}
        clothesButton.setOnClickListener{clothesButtonDonation()}
        medicineButton.setOnClickListener{medicineButtonDonation()}
        foodButton.setOnClickListener{foodButtonDonation()}
        constructionMaterialsButton.setOnClickListener{constructionMaterialsButtonDonation()}
    }

    private fun waterButtonDonation(){

        // we find the sponsors that are donating water
        //cc.captaincode.hurrileaf.activities.paymentDonation.ui.PaymentDonationActivity
        val intent = Intent(this,PaymentDonationActivity::class.java).apply{

        }
        startActivity(intent)
    }

    private fun clothesButtonDonation(){
        // we find the sponsors that are donating clothes
    }

    private fun medicineButtonDonation(){
        // we find the sponsors that donating medicine
    }
    private fun foodButtonDonation(){

    }
    private fun constructionMaterialsButtonDonation(){

    }
}
